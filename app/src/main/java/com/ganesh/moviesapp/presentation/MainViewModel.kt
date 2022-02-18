package com.ganesh.moviesapp.presentation

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.ganesh.moviesapp.MoviesRepository
import com.ganesh.moviesapp.data.entity.MovieEntity
import javax.inject.Inject

class MainViewModel @Inject constructor(): ViewModel() {
    val popularMovies: MutableLiveData<MutableList<MovieEntity>> = MutableLiveData(mutableListOf())
    val upcomingMovies: MutableLiveData<MutableList<MovieEntity>> = MutableLiveData(mutableListOf())
    val topRatedMovies: MutableLiveData<MutableList<MovieEntity>> = MutableLiveData(mutableListOf())

    fun init() {
        getPopularMovies(1)
        getTopRatedMovies(1)
        getUpcomingMovies(1)
    }

    public fun getPopularMovies(page: Int) {
        MoviesRepository.getPopularMovies(
            page,
            ::onPopularMoviesFetched,
            ::onError
        )
    }

    public fun getTopRatedMovies(page: Int) {
        MoviesRepository.getTopRatedMovies(
            page,
            ::onTopRatedMoviesFetched,
            ::onError
        )
    }

    public fun getUpcomingMovies(page: Int) {
        MoviesRepository.getUpcomingMovies(
            page,
            ::onUpcomingMoviesFetched,
            ::onError
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