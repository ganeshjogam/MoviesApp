package com.ganesh.moviesapp.presentation.upcomingmovies

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

class UpcomingMoviesFragment : Fragment() {
    private lateinit var upcomingMovies: RecyclerView
    private lateinit var upcomingMoviesAdapter: MoviesAdapter
    private lateinit var upcomingMoviesLayoutMgr: LinearLayoutManager

    @Inject
    lateinit var upcomingMoviesViewModel: UpcomingMoviesViewModel

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        upcomingMoviesViewModel.init()
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
        val view = inflater.inflate(R.layout.fragment_upcoming_movies, container, false)
        upcomingMovies = view.findViewById(R.id.upcoming_movies)
        upcomingMoviesLayoutMgr = LinearLayoutManager(
            activity,
            LinearLayoutManager.HORIZONTAL,
            false
        )
        upcomingMovies.layoutManager = upcomingMoviesLayoutMgr
        upcomingMoviesAdapter = MoviesAdapter(mutableListOf()) { movie -> showMovieDetails(movie) }
        upcomingMovies.adapter = upcomingMoviesAdapter

        upcomingMoviesViewModel.data.upcomingMovies.observe(viewLifecycleOwner) {
                movies -> upcomingMoviesAdapter.appendMovies(movies)
            attachUpcomingMoviesOnScrollListener()
        }

        return view
    }

    private fun attachUpcomingMoviesOnScrollListener() {
        upcomingMovies.addOnScrollListener(object : RecyclerView.OnScrollListener() {
            override fun onScrolled(recyclerView: RecyclerView, dx: Int, dy: Int) {
                val totalItemCount = upcomingMoviesLayoutMgr.itemCount
                val visibleItemCount = upcomingMoviesLayoutMgr.childCount
                val firstVisibleItem = upcomingMoviesLayoutMgr.findFirstVisibleItemPosition()

                if (firstVisibleItem + visibleItemCount >= totalItemCount / 2) {
                    upcomingMovies.removeOnScrollListener(this)
                    upcomingMoviesViewModel.getUpcomingMovies()
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
            UpcomingMoviesFragment().apply {
                arguments = Bundle().apply {

                }
            }
    }
}