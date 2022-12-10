package com.ganesh.moviesapp.data.sources.remote

import com.ganesh.moviesapp.core.BaseFailure
import com.ganesh.moviesapp.core.BaseResult
import com.ganesh.moviesapp.data.entity.MoviesResponseEntity

interface MovieRemoteSource {
    suspend fun getPopularMovies(
        page: Int
    ) : BaseResult<BaseFailure, MoviesResponseEntity>

    suspend fun getTopRatedMovies(
        page: Int
    ) : BaseResult<BaseFailure, MoviesResponseEntity>

    suspend fun getUpcomingMovies(
        page: Int
    ) : BaseResult<BaseFailure, MoviesResponseEntity>
}