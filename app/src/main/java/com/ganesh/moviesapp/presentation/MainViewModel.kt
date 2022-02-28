package com.ganesh.moviesapp.presentation

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.ganesh.moviesapp.domain.model.MovieModel
import com.ganesh.moviesapp.domain.usecase.*
import com.ganesh.moviesapp.presentation.mapper.MovieMapper

class MainViewModel constructor(
    private val getPopularMoviesUseCase: GetPopularMoviesUseCase,
    private val getTopRatedMoviesUseCase: GetTopRatedMoviesUseCase,
    private val getUpcomingMoviesUseCase: GetUpcomingMoviesUseCase,
    private val mapper: MovieMapper
): ViewModel() {
    val popularMovies: MutableLiveData<MutableList<MovieViewData>> = MutableLiveData(mutableListOf())
    val upcomingMovies: MutableLiveData<MutableList<MovieViewData>> = MutableLiveData(mutableListOf())
    val topRatedMovies: MutableLiveData<MutableList<MovieViewData>> = MutableLiveData(mutableListOf())

    fun init() {
        getPopularMovies(1)
        getTopRatedMovies(1)
        getUpcomingMovies(1)
    }

    fun getPopularMovies(page: Int) {
        getPopularMoviesUseCase(
            params = PopularMoviesRequest(
                page = page,
                onSuccess = ::onPopularMoviesFetched,
                onError = ::onError
            )
        )
    }

    fun getTopRatedMovies(page: Int) {
        getTopRatedMoviesUseCase(
            params = TopRatedMoviesRequest(
                page = page,
                onSuccess = ::onTopRatedMoviesFetched,
                onError = ::onError
            )
        )
    }

    fun getUpcomingMovies(page: Int) {
        getUpcomingMoviesUseCase(
            params = UpcomingMoviesRequest(
                page = page,
                onSuccess = ::onUpcomingMoviesFetched,
                onError = ::onError
            )
        )
    }

    private fun onPopularMoviesFetched(movies: List<MovieModel>) {
        val totalList = popularMovies.value ?: mutableListOf()
        totalList.addAll(mapper.toViewData(movies))
        popularMovies.postValue(totalList)
    }

    private fun onTopRatedMoviesFetched(movies: List<MovieModel>) {
        val totalList = topRatedMovies.value ?: mutableListOf()
        totalList.addAll(mapper.toViewData(movies))
        topRatedMovies.postValue(totalList)
    }

    private fun onUpcomingMoviesFetched(movies: List<MovieModel>) {
        val totalList = upcomingMovies.value ?: mutableListOf()
        totalList.addAll(mapper.toViewData(movies))
        upcomingMovies.postValue(totalList)
    }

    private fun onError() {

    }
}