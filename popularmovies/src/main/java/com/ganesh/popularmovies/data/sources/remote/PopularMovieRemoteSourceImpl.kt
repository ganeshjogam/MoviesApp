package com.ganesh.popularmovies.data.sources.remote

import com.ganesh.core.BaseFailure
import com.ganesh.core.BaseResult
import com.ganesh.core.request
import com.ganesh.popularmovies.data.entity.PopularMoviesResponseEntity
import com.ganesh.popularmovies.data.sources.remote.api.PopularMoviesApi

class PopularMovieRemoteSourceImpl(private val api: PopularMoviesApi) : PopularMovieRemoteSource {
    override suspend fun getPopularMovies(
        page: Int
    ): BaseResult<BaseFailure, PopularMoviesResponseEntity> =
        request(
            { api.getPopularMovies(page = page) },
            { entity, _ -> entity.body()!! }
        )
}