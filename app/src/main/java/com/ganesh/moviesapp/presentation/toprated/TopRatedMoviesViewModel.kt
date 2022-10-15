package com.ganesh.moviesapp.presentation.toprated

import com.ganesh.moviesapp.core.BaseViewModel
import com.ganesh.moviesapp.core.Scope
import com.ganesh.moviesapp.domain.model.MovieModel
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
        getTopRatedMovies(1)
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

    private fun onTopRatedMoviesFetched(movies: List<MovieModel>) {
        val totalList = data.topRatedMovies.value?.toMutableList() ?: mutableListOf()
        totalList.addAll(mapper.toViewData(movies))
        data.topRatedMovies.postValue(totalList)
    }

    private fun onError() {

    }
}