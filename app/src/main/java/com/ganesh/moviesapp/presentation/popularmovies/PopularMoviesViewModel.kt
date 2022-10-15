package com.ganesh.moviesapp.presentation.popularmovies

import com.ganesh.moviesapp.core.BaseFailure
import com.ganesh.moviesapp.core.BaseViewModel
import com.ganesh.moviesapp.core.Scope
import com.ganesh.moviesapp.domain.model.MovieModel
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
        getPopularMovies(1)
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

    private fun onPopularMoviesFetched(movies: List<MovieModel>) {
        val totalList = data.popularMovies.value?.toMutableList() ?: mutableListOf()
        totalList.addAll(mapper.toViewData(movies))
        data.popularMovies.postValue(totalList)
    }

    private fun handlePopularMovieError(failure: BaseFailure) {
        data.error()
    }
}