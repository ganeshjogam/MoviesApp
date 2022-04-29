package com.ganesh.moviesapp.domain.repository

import com.ganesh.moviesapp.core.BaseFailure
import com.ganesh.moviesapp.core.BaseResult
import com.ganesh.moviesapp.domain.model.MovieModel

interface MovieRepository {
    suspend fun getPopularMovies(
        page: Int
    ) : BaseResult<BaseFailure, List<MovieModel>>

    fun getTopRatedMovies(
        page: Int,
        onSuccess: (movies: List<MovieModel>) -> Unit,
        onError: () -> Unit
    )

    fun getUpcomingMovies(
        page: Int,
        onSuccess: (movies: List<MovieModel>) -> Unit,
        onError: () -> Unit
    )
}