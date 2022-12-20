package com.ganesh.upcomingmovies.data.sources.remote

import com.ganesh.core.BaseFailure
import com.ganesh.core.BaseResult
import com.ganesh.core.request
import com.ganesh.upcomingmovies.data.entity.UpcomingMoviesResponseEntity
import com.ganesh.upcomingmovies.data.sources.remote.api.UpcomingMoviesApi

class UpcomingMovieRemoteSourceImpl(private val api: UpcomingMoviesApi) : UpcomingMovieRemoteSource {
    override suspend fun getPopularMovies(
        page: Int
    ): BaseResult<BaseFailure, UpcomingMoviesResponseEntity> =
        request(
            { api.getUpcomingMovies(page = page) },
            { entity, _ -> entity.body()!! }
        )
}