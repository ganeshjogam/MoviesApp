package com.ganesh.popularmovies.data.sources.remote

import com.ganesh.core.BaseFailure
import com.ganesh.core.BaseResult
import com.ganesh.popularmovies.data.entity.PopularMoviesResponseEntity

interface PopularMovieRemoteSource {
    suspend fun getPopularMovies(
        page: Int
    ) : BaseResult<BaseFailure, PopularMoviesResponseEntity>
}