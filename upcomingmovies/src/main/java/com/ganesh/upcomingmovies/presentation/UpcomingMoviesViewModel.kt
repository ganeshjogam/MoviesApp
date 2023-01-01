package com.ganesh.upcomingmovies.presentation

import com.ganesh.core.BaseFailure
import com.ganesh.core.BaseViewModel
import com.ganesh.core.Scope
import com.ganesh.upcomingmovies.domain.model.UpcomingMovieResponseModel
import com.ganesh.upcomingmovies.domain.usecase.GetUpcomingMoviesUseCase
import com.ganesh.upcomingmovies.domain.usecase.UpcomingMoviesRequest
import com.ganesh.upcomingmovies.presentation.mapper.UpcomingMovieMapper

class UpcomingMoviesViewModel(
    scope: Scope,
    data: UpcomingMovieViewData,
    private val getUpcomingMoviesUseCase: GetUpcomingMoviesUseCase,
    private val mapper: UpcomingMovieMapper
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

    private fun onUpcomingMoviesFetched(movies: UpcomingMovieResponseModel) {
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