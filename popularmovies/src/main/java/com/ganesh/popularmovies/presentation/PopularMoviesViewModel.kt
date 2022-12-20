package com.ganesh.popularmovies.presentation

import com.ganesh.core.BaseFailure
import com.ganesh.core.BaseViewModel
import com.ganesh.core.Scope
import com.ganesh.popularmovies.domain.usecase.GetPopularMoviesUseCase
import com.ganesh.popularmovies.domain.usecase.PopularMoviesRequest
import com.ganesh.popularmovies.domain.model.PopularMovieResponseModel
import com.ganesh.popularmovies.presentation.mapper.PopularMovieMapper

class PopularMoviesViewModel(
    scope: Scope,
    data: PopularMovieViewData,
    private val getPopularMoviesUseCase: GetPopularMoviesUseCase,
    private val mapper: PopularMovieMapper
): BaseViewModel<PopularMovieViewData>(scope, data) {

    fun init() {
        getPopularMovies()
    }

    fun getPopularMovies() {
        execute {
            data.loading()
            getPopularMoviesUseCase(
                params = PopularMoviesRequest(
                    page = data.currentPage.value!!
                )
            ).fold(
                ::handlePopularMovieError,
                ::onPopularMoviesFetched
            )
        }
    }

    private fun onPopularMoviesFetched(movies: PopularMovieResponseModel) {
        val totalList = data.popularMovies.value?.toMutableList() ?: mutableListOf()
        totalList.addAll(mapper.toViewData(movies.movies))
        data.popularMovies.postValue(totalList)
        data.currentPage.postValue(data.currentPage.value!! + 1)
        data.totalPages.postValue(movies.totalPages)
    }

    private fun handlePopularMovieError(failure: BaseFailure) {
        data.error()
    }
}