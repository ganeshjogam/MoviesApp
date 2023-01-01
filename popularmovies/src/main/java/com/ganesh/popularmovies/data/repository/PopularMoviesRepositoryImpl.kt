package com.ganesh.popularmovies.data.repository

import com.ganesh.core.BaseFailure
import com.ganesh.core.BaseResult
import com.ganesh.popularmovies.data.mapper.PopularMovieResponseMapper
import com.ganesh.popularmovies.data.sources.local.PopularMovieLocalSource
import com.ganesh.popularmovies.data.sources.remote.PopularMovieRemoteSource
import com.ganesh.popularmovies.domain.model.PopularMovieResponseModel
import com.ganesh.popularmovies.domain.repository.PopularMovieRepository

class PopularMoviesRepositoryImpl(
    val localSource: PopularMovieLocalSource,
    private val remoteSource: PopularMovieRemoteSource,
    private val mapper: PopularMovieResponseMapper
) : PopularMovieRepository {
    override suspend fun getPopularMovies(
        page: Int
    ): BaseResult<BaseFailure, PopularMovieResponseModel> {
        val response = remoteSource.getPopularMovies(page)
        if (response.isSuccess) {
            val result = (response as BaseResult.Success).success
            return BaseResult.Success(mapper.toMovieListModel(result))
        }

        return response as BaseResult.Error
    }
}
