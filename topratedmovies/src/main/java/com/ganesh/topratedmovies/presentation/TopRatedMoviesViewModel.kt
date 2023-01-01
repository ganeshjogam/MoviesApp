package com.ganesh.topratedmovies.presentation

import com.ganesh.core.BaseFailure
import com.ganesh.core.BaseViewModel
import com.ganesh.core.Scope
import com.ganesh.topratedmovies.domain.model.TopRatedMovieResponseModel
import com.ganesh.topratedmovies.domain.usecase.GetTopRatedMoviesUseCase
import com.ganesh.topratedmovies.domain.usecase.TopRatedMoviesRequest
import com.ganesh.topratedmovies.presentation.mapper.TopRatedMovieMapper

class TopRatedMoviesViewModel(
    scope: Scope,
    data: TopRatedMovieViewData,
    private val getTopRatedMoviesUseCase: GetTopRatedMoviesUseCase,
    private val mapper: TopRatedMovieMapper
): BaseViewModel<TopRatedMovieViewData>(scope, data) {
    fun init() {
        getTopRatedMovies()
    }

    fun getTopRatedMovies() {
        execute {
            data.loading()
            getTopRatedMoviesUseCase(
                params = TopRatedMoviesRequest(
                    page = data.currentPage.value!!
                )
            ).fold(
                ::handleTopRatedMoviesError,
                ::onTopRatedMoviesFetched
            )
        }
    }

    private fun onTopRatedMoviesFetched(movies: TopRatedMovieResponseModel) {
        val totalList = data.topRatedMovies.value?.toMutableList() ?: mutableListOf()
        totalList.addAll(mapper.toViewData(movies.movies))
        data.topRatedMovies.postValue(totalList)
        data.currentPage.postValue(data.currentPage.value!! + 1)
        data.totalPages.postValue(movies.totalPages)
    }

    private fun handleTopRatedMoviesError(failure: BaseFailure) {
        data.error()
    }
}