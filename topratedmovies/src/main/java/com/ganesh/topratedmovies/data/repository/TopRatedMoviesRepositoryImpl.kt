package com.ganesh.topratedmovies.data.repository

import com.ganesh.core.BaseFailure
import com.ganesh.core.BaseResult
import com.ganesh.topratedmovies.data.mapper.TopRatedMovieResponseMapper
import com.ganesh.topratedmovies.data.sources.remote.TopRatedMovieRemoteSource
import com.ganesh.topratedmovies.domain.model.TopRatedMovieResponseModel
import com.ganesh.topratedmovies.domain.repository.TopRatedMovieRepository

class TopRatedMoviesRepositoryImpl(
    private val remoteSource: TopRatedMovieRemoteSource,
    private val mapper: TopRatedMovieResponseMapper
) : TopRatedMovieRepository {
    override suspend fun getPopularMovies(
        page: Int
    ): BaseResult<BaseFailure, TopRatedMovieResponseModel> {
        val response = remoteSource.getPopularMovies(page)
        if (response.isSuccess) {
            val result = (response as BaseResult.Success).success
            return BaseResult.Success(mapper.toMovieListModel(result))
        }

        return response as BaseResult.Error
    }
}
