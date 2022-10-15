package com.ganesh.moviesapp.presentation.toprated

import android.content.Context
import android.content.Intent
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.ganesh.moviesapp.*
import com.ganesh.moviesapp.presentation.MovieItemViewData
import dagger.android.support.AndroidSupportInjection
import javax.inject.Inject

class TopRatedMoviesFragment : Fragment() {
    private lateinit var topRatedMovies: RecyclerView
    private lateinit var topRatedMoviesAdapter: MoviesAdapter
    private lateinit var topRatedMoviesLayoutMgr: LinearLayoutManager
    private var topRatedMoviesPage = 1

    @Inject
    lateinit var topRatedMoviesViewModel: TopRatedMoviesViewModel

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        topRatedMoviesViewModel.init()
        arguments?.let {

        }
    }

    override fun onAttach(context: Context) {
        AndroidSupportInjection.inject(this)
        super.onAttach(context)
    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        val view = inflater.inflate(R.layout.fragment_top_rated_movies, container, false)
        topRatedMovies = view.findViewById(R.id.top_rated_movies)
        topRatedMoviesLayoutMgr = LinearLayoutManager(
            activity,
            LinearLayoutManager.HORIZONTAL,
            false
        )
        topRatedMovies.layoutManager = topRatedMoviesLayoutMgr
        topRatedMoviesAdapter = MoviesAdapter(mutableListOf()) { movie -> showMovieDetails(movie) }
        topRatedMovies.adapter = topRatedMoviesAdapter

        topRatedMoviesViewModel.data.topRatedMovies.observe(viewLifecycleOwner){
                movies -> topRatedMoviesAdapter.appendMovies(movies)
            attachTopRatedMoviesOnScrollListener()
        }
        return view
    }

    private fun attachTopRatedMoviesOnScrollListener() {
        topRatedMovies.addOnScrollListener(object : RecyclerView.OnScrollListener() {
            override fun onScrolled(recyclerView: RecyclerView, dx: Int, dy: Int) {
                val totalItemCount = topRatedMoviesLayoutMgr.itemCount
                val visibleItemCount = topRatedMoviesLayoutMgr.childCount
                val firstVisibleItem = topRatedMoviesLayoutMgr.findFirstVisibleItemPosition()

                if (firstVisibleItem + visibleItemCount >= totalItemCount / 2) {
                    topRatedMovies.removeOnScrollListener(this)
                    topRatedMoviesPage++
                    topRatedMoviesViewModel.getTopRatedMovies(topRatedMoviesPage)
                }
            }
        })
    }

    private fun showMovieDetails(movieItem: MovieItemViewData) {
        val intent = Intent(activity, MovieDetailsActivity::class.java)
        intent.putExtra(MOVIE_BACKDROP, movieItem.backdropPath)
        intent.putExtra(MOVIE_POSTER, movieItem.posterPath)
        intent.putExtra(MOVIE_TITLE, movieItem.title)
        intent.putExtra(MOVIE_RATING, movieItem.rating)
        intent.putExtra(MOVIE_RELEASE_DATE, movieItem.releaseDate)
        intent.putExtra(MOVIE_OVERVIEW, movieItem.overview)
        startActivity(intent)
    }

    companion object {
        @JvmStatic
        fun newInstance() =
            TopRatedMoviesFragment().apply {
                arguments = Bundle().apply {

                }
            }
    }
}