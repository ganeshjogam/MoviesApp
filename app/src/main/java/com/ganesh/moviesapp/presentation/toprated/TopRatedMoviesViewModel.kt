package com.ganesh.moviesapp.presentation.toprated

import com.ganesh.core.BaseFailure
import com.ganesh.core.BaseViewModel
import com.ganesh.core.Scope
import com.ganesh.moviesapp.domain.model.MovieResponseModel
import com.ganesh.moviesapp.domain.usecase.GetTopRatedMoviesUseCase
import com.ganesh.moviesapp.domain.usecase.TopRatedMoviesRequest
import com.ganesh.moviesapp.presentation.mapper.MovieMapper

class TopRatedMoviesViewModel(
    scope: Scope,
    data: TopRatedMovieViewData,
    private val getTopRatedMoviesUseCase: GetTopRatedMoviesUseCase,
    private val mapper: MovieMapper
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

    private fun onTopRatedMoviesFetched(movies: MovieResponseModel) {
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