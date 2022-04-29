package com.ganesh.moviesapp.data.sources.remote

import com.ganesh.moviesapp.core.BaseFailure
import com.ganesh.moviesapp.core.BaseResult
import com.ganesh.moviesapp.data.entity.MovieEntity
import com.ganesh.moviesapp.data.entity.MoviesResponseEntity

interface MovieRemoteSource {
    suspend fun getPopularMovies(
        page: Int
    ) : BaseResult<BaseFailure, MoviesResponseEntity>

    fun getTopRatedMovies(
        page: Int,
        onSuccess: (movieResponse: MoviesResponseEntity) -> Unit,
        onError: () -> Unit
    )

    fun getUpcomingMovies(
        page: Int,
        onSuccess: (movieResponse: MoviesResponseEntity) -> Unit,
        onError: () -> Unit
    )
}