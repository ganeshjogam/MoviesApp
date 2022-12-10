package com.ganesh.moviesapp.presentation.upcomingmovies

import com.ganesh.moviesapp.core.BaseFailure
import com.ganesh.moviesapp.core.BaseViewModel
import com.ganesh.moviesapp.core.Scope
import com.ganesh.moviesapp.domain.model.MovieResponseModel
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

        getUpcomingMovies()
    }

    fun getUpcomingMovies() {
        execute {
            data.loading()
            getUpcomingMoviesUseCase(
                params = UpcomingMoviesRequest(
                    page = data.currentPage.value!!
                )
            ).fold(
                ::handleUpcomingMoviesError,
                ::onUpcomingMoviesFetched
            )
        }
    }

    private fun onUpcomingMoviesFetched(movies: MovieResponseModel) {
        val totalList = data.upcomingMovies.value?.toMutableList() ?: mutableListOf()
        totalList.addAll(mapper.toViewData(movies.movies))
        data.upcomingMovies.postValue(totalList)
        data.currentPage.postValue(data.currentPage.value!! + 1)
        data.totalPages.postValue(movies.totalPages)
    }

    private fun handleUpcomingMoviesError(failure: BaseFailure) {
        data.error()
    }
}