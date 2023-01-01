package com.ganesh.upcomingmovies.data.repository

import com.ganesh.core.BaseFailure
import com.ganesh.core.BaseResult
import com.ganesh.upcomingmovies.data.mapper.UpcomingMovieResponseMapper
import com.ganesh.upcomingmovies.data.sources.remote.UpcomingMovieRemoteSource
import com.ganesh.upcomingmovies.domain.model.UpcomingMovieResponseModel
import com.ganesh.upcomingmovies.domain.repository.UpcomingMovieRepository

class UpcomingMoviesRepositoryImpl(
    private val remoteSource: UpcomingMovieRemoteSource,
    private val mapper: UpcomingMovieResponseMapper
) : UpcomingMovieRepository {
    override suspend fun getPopularMovies(
        page: Int
    ): BaseResult<BaseFailure, UpcomingMovieResponseModel> {
        val response = remoteSource.getPopularMovies(page)
        if (response.isSuccess) {
            val result = (response as BaseResult.Success).success
            return BaseResult.Success(mapper.toMovieListModel(result))
        }

        return response as BaseResult.Error
    }
}
