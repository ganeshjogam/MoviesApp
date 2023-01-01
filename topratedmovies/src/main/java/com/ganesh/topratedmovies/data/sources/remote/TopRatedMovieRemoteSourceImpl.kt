package com.ganesh.topratedmovies.data.sources.remote

import com.ganesh.core.BaseFailure
import com.ganesh.core.BaseResult
import com.ganesh.core.request
import com.ganesh.topratedmovies.data.entity.TopRatedMoviesResponseEntity
import com.ganesh.topratedmovies.data.sources.remote.api.TopRatedMoviesApi

class TopRatedMovieRemoteSourceImpl(private val api: TopRatedMoviesApi) : TopRatedMovieRemoteSource {
    override suspend fun getPopularMovies(
        page: Int
    ): BaseResult<BaseFailure, TopRatedMoviesResponseEntity> =
        request(
            { api.getTopRatedMovies(page = page) },
            { entity, _ -> entity.body()!! }
        )
}