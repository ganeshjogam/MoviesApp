package com.ganesh.topratedmovies.data.sources.remote

import com.ganesh.core.BaseFailure
import com.ganesh.core.BaseResult
import com.ganesh.topratedmovies.data.entity.TopRatedMoviesResponseEntity

interface TopRatedMovieRemoteSource {
    suspend fun getPopularMovies(
        page: Int
    ) : BaseResult<BaseFailure, TopRatedMoviesResponseEntity>
}