package com.ganesh.moviesapp.presentation.popularmovies

import com.ganesh.core.BaseFailure
import com.ganesh.core.BaseViewModel
import com.ganesh.core.Scope
import com.ganesh.moviesapp.domain.model.MovieResponseModel
import com.ganesh.moviesapp.domain.usecase.GetPopularMoviesUseCase
import com.ganesh.moviesapp.domain.usecase.PopularMoviesRequest
import com.ganesh.moviesapp.presentation.mapper.MovieMapper

class PopularMoviesViewModel(
    scope: Scope,
    data: PopularMovieViewData,
    private val getPopularMoviesUseCase: GetPopularMoviesUseCase,
    private val mapper: MovieMapper
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

    private fun onPopularMoviesFetched(movies: MovieResponseModel) {
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