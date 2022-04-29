package com.ganesh.moviesapp.data.repository

import com.ganesh.moviesapp.core.BaseFailure
import com.ganesh.moviesapp.core.BaseResult
import com.ganesh.moviesapp.data.mapper.MovieResponseMapper
import com.ganesh.moviesapp.data.sources.local.MovieLocalSource
import com.ganesh.moviesapp.data.sources.remote.MovieRemoteSource
import com.ganesh.moviesapp.domain.model.MovieModel
import com.ganesh.moviesapp.domain.repository.MovieRepository

class MoviesRepositoryImpl(
    val localSource: MovieLocalSource,
    private val remoteSource: MovieRemoteSource,
    private val mapper: MovieResponseMapper
) : MovieRepository {
    override suspend fun getPopularMovies(
        page: Int
    ): BaseResult<BaseFailure, List<MovieModel>> {
        val response = remoteSource.getPopularMovies(page)
        if (response.isSuccess) {
            val result = (response as BaseResult.Success).success
            return BaseResult.Success(mapper.toMovieListModel(result))
        }

        return response as BaseResult.Error
    }

    override fun getTopRatedMovies(
        page: Int,
        onSuccess: (movies: List<MovieModel>) -> Unit,
        onError: () -> Unit
    ) {
        remoteSource.getTopRatedMovies(page,
            { movieResponse -> onSuccess(mapper.toMovieListModel(movieResponse)) },
            { onError() })
    }

    override fun getUpcomingMovies(
        page: Int,
        onSuccess: (movies: List<MovieModel>) -> Unit,
        onError: () -> Unit
    ) {
        remoteSource.getUpcomingMovies(page,
            { movieResponse -> onSuccess(mapper.toMovieListModel(movieResponse)) },
            { onError() })
    }

}
