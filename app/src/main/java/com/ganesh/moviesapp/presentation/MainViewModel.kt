package com.ganesh.moviesapp.presentation

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.ganesh.moviesapp.core.BaseFailure
import com.ganesh.moviesapp.core.BaseViewModel
import com.ganesh.moviesapp.core.Scope
import com.ganesh.moviesapp.domain.model.MovieModel
import com.ganesh.moviesapp.domain.usecase.*
import com.ganesh.moviesapp.presentation.mapper.MovieMapper

class MainViewModel constructor(
    scope: Scope,
    data: MovieViewData,
    private val getPopularMoviesUseCase: GetPopularMoviesUseCase,
    private val getTopRatedMoviesUseCase: GetTopRatedMoviesUseCase,
    private val getUpcomingMoviesUseCase: GetUpcomingMoviesUseCase,
    private val mapper: MovieMapper
): BaseViewModel<MovieViewData>(scope, data) {

    fun init() {
        getPopularMovies(1)
        getTopRatedMovies(1)
        getUpcomingMovies(1)
    }

    fun getPopularMovies(page: Int) {
        execute {
            data.loading()
            getPopularMoviesUseCase(
                params = PopularMoviesRequest(
                    page = page
                )
            ).fold(
                ::handlePopularMovieError,
                ::onPopularMoviesFetched
            )
        }
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
        val totalList = data.popularMovies.value?.toMutableList() ?: mutableListOf()
        totalList.addAll(mapper.toViewData(movies))
        data.popularMovies.postValue(totalList)
    }

    private fun onTopRatedMoviesFetched(movies: List<MovieModel>) {
        val totalList = data.topRatedMovies.value?.toMutableList() ?: mutableListOf()
        totalList.addAll(mapper.toViewData(movies))
        data.topRatedMovies.postValue(totalList)
    }

    private fun onUpcomingMoviesFetched(movies: List<MovieModel>) {
        val totalList = data.upcomingMovies.value?.toMutableList() ?: mutableListOf()
        totalList.addAll(mapper.toViewData(movies))
        data.upcomingMovies.postValue(totalList)
    }

    private fun handlePopularMovieError(failure: BaseFailure) {
        data.error()
    }

    private fun onError() {

    }
}