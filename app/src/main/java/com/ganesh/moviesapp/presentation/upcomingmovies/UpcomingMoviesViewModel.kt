package com.ganesh.moviesapp.presentation.upcomingmovies

import com.ganesh.moviesapp.core.BaseViewModel
import com.ganesh.moviesapp.core.Scope
import com.ganesh.moviesapp.domain.model.MovieModel
import com.ganesh.moviesapp.domain.usecase.GetUpcomingMoviesUseCase
import com.ganesh.moviesapp.domain.usecase.UpcomingMoviesRequest
import com.ganesh.moviesapp.presentation.mapper.MovieMapper

class UpcomingMoviesViewModel(
    scope: Scope,
    data: UpcomingMovieViewData,
    private val getUpcomingMoviesUseCase: GetUpcomingMoviesUseCase,
    private val mapper: MovieMapper
) : BaseViewModel<UpcomingMovieViewData>(scope, data) {
    fun init() {

        getUpcomingMovies(1)
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

    private fun onUpcomingMoviesFetched(movies: List<MovieModel>) {
        val totalList = data.upcomingMovies.value?.toMutableList() ?: mutableListOf()
        totalList.addAll(mapper.toViewData(movies))
        data.upcomingMovies.postValue(totalList)
    }

    private fun onError() {

    }
}