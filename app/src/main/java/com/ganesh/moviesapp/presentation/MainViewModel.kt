package com.ganesh.moviesapp.presentation

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.ganesh.moviesapp.data.entity.MovieEntity
import com.ganesh.moviesapp.domain.repository.MovieRepository
import com.ganesh.moviesapp.domain.usecase.*

class MainViewModel constructor(
    private val getPopularMoviesUseCase: GetPopularMoviesUseCase,
    private val getTopRatedMoviesUseCase: GetTopRatedMoviesUseCase,
    private val getUpcomingMoviesUseCase: GetUpcomingMoviesUseCase
): ViewModel() {
    val popularMovies: MutableLiveData<MutableList<MovieEntity>> = MutableLiveData(mutableListOf())
    val upcomingMovies: MutableLiveData<MutableList<MovieEntity>> = MutableLiveData(mutableListOf())
    val topRatedMovies: MutableLiveData<MutableList<MovieEntity>> = MutableLiveData(mutableListOf())

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

    private fun onPopularMoviesFetched(movies: List<MovieEntity>) {
        val totalList = popularMovies.value ?: mutableListOf()
        totalList.addAll(movies)
        popularMovies.postValue(totalList)
    }

    private fun onTopRatedMoviesFetched(movies: List<MovieEntity>) {
        val totalList = topRatedMovies.value ?: mutableListOf()
        totalList.addAll(movies)
        topRatedMovies.postValue(totalList)
    }

    private fun onUpcomingMoviesFetched(movies: List<MovieEntity>) {
        val totalList = upcomingMovies.value ?: mutableListOf()
        totalList.addAll(movies)
        upcomingMovies.postValue(totalList)
    }

    private fun onError() {

    }
}