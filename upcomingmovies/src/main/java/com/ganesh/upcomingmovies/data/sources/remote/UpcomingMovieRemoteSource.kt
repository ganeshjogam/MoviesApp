package com.ganesh.upcomingmovies.data.sources.remote

import com.ganesh.core.BaseFailure
import com.ganesh.core.BaseResult
import com.ganesh.upcomingmovies.data.entity.UpcomingMoviesResponseEntity

interface UpcomingMovieRemoteSource {
    suspend fun getPopularMovies(
        page: Int
    ) : BaseResult<BaseFailure, UpcomingMoviesResponseEntity>
}