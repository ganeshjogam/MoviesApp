package com.ganesh.popularmovies.presentation

import android.content.Context
import android.content.Intent
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.ganesh.popularmovies.R
import com.ganesh.productdetails.presentation.MOVIE_BACKDROP
import com.ganesh.productdetails.presentation.MOVIE_OVERVIEW
import com.ganesh.productdetails.presentation.MOVIE_POSTER
import com.ganesh.productdetails.presentation.MOVIE_RATING
import com.ganesh.productdetails.presentation.MOVIE_RELEASE_DATE
import com.ganesh.productdetails.presentation.MOVIE_TITLE
import com.ganesh.productdetails.presentation.MovieDetailsActivity
import dagger.android.support.AndroidSupportInjection
import javax.inject.Inject

class PopularMoviesFragment : Fragment() {

    private lateinit var popularMovies: RecyclerView
    private lateinit var popularMoviesLayoutMgr: LinearLayoutManager
    private lateinit var popularMoviesAdapter: PopularMoviesAdapter

    @Inject
    lateinit var popularMoviesViewModel: PopularMoviesViewModel

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        popularMoviesViewModel.init()
    }

    override fun onAttach(context: Context) {
        AndroidSupportInjection.inject(this)
        super.onAttach(context)
    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragmentN
        val view = inflater.inflate(R.layout.fragment_popular_movies, container, false)
        popularMovies = view.findViewById(R.id.popular_movies)
        popularMoviesLayoutMgr = LinearLayoutManager(
            activity,
            LinearLayoutManager.HORIZONTAL,
            false
        )
        popularMovies.layoutManager = popularMoviesLayoutMgr
        popularMoviesAdapter = PopularMoviesAdapter(mutableListOf()) { movie ->
            showMovieDetails(movie)
        }
        popularMovies.adapter = popularMoviesAdapter

        popularMoviesViewModel.data.popularMovies.observe(viewLifecycleOwner) { movies ->
            popularMoviesAdapter.appendMovies(movies)
            attachPopularMoviesOnScrollListener()
        }

        return view
    }

    private fun attachPopularMoviesOnScrollListener() {
        popularMovies.addOnScrollListener(object : RecyclerView.OnScrollListener() {
            override fun onScrolled(recyclerView: RecyclerView, dx: Int, dy: Int) {
                val totalItemCount = popularMoviesLayoutMgr.itemCount
                val visibleItemCount = popularMoviesLayoutMgr.childCount
                val firstVisibleItem = popularMoviesLayoutMgr.findFirstVisibleItemPosition()

                if (firstVisibleItem + visibleItemCount >= totalItemCount / 2) {
                    popularMovies.removeOnScrollListener(this)
                    popularMoviesViewModel.getPopularMovies()
                }
            }
        })
    }

    private fun showMovieDetails(movieItem: PopularMovieItemViewData) {
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
            PopularMoviesFragment().apply {
                arguments = Bundle().apply {

                }
            }
    }
}