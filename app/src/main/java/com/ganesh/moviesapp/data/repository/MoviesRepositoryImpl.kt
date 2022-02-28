package com.ganesh.moviesapp.data.repository

import com.ganesh.moviesapp.data.entity.MovieEntity
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
    override fun getPopularMovies(
        page: Int,
        onSuccess: (movies: List<MovieModel>) -> Unit,
        onError: () -> Unit
    ) {
        remoteSource.getPopularMovies(page,
            { movieResponse -> onSuccess(mapper.toMovieListModel(movieResponse)) },
            { onError() })
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
