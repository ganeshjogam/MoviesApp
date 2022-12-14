package com.ganesh.moviesapp.data.sources.remote

import com.ganesh.core.BaseFailure
import com.ganesh.core.BaseResult
import com.ganesh.core.request
import com.ganesh.moviesapp.data.entity.MoviesResponseEntity
import com.ganesh.moviesapp.data.sources.remote.api.Api

class MovieRemoteSourceImpl(private val api: Api) : MovieRemoteSource {
    override suspend fun getPopularMovies(
        page: Int
    ): BaseResult<BaseFailure, MoviesResponseEntity> =
        request(
            { api.getPopularMovies(page = page) },
            { entity, _ -> entity.body()!! }
        )

    override suspend fun getTopRatedMovies(
        page: Int
    ) = request(
        { api.getTopRatedMovies(page = page) },
        { entity, _ -> entity.body()!! }
    )

    override suspend fun getUpcomingMovies(
        page: Int
    ) = request(
        { api.getUpcomingMovies(page = page) },
        { entity, _ -> entity.body()!! }
    )
}