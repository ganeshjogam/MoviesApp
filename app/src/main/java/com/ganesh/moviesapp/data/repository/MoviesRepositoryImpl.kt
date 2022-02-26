package com.ganesh.moviesapp.data.repository

import com.ganesh.moviesapp.data.entity.MovieEntity
import com.ganesh.moviesapp.data.sources.local.MovieLocalSource
import com.ganesh.moviesapp.data.sources.remote.MovieRemoteSource
import com.ganesh.moviesapp.domain.repository.MovieRepository

class MoviesRepositoryImpl(
    val localSource: MovieLocalSource,
    private val remoteSource: MovieRemoteSource
): MovieRepository {
    override fun getPopularMovies(
        page: Int,
        onSuccess: (movies: List<MovieEntity>) -> Unit,
        onError: () -> Unit
    ) {
        remoteSource.getPopularMovies(page, onSuccess, onError)
    }

    override fun getTopRatedMovies(
        page: Int,
        onSuccess: (movies: List<MovieEntity>) -> Unit,
        onError: () -> Unit
    ) {
        remoteSource.getTopRatedMovies(page, onSuccess, onError)
    }

    override fun getUpcomingMovies(
        page: Int,
        onSuccess: (movies: List<MovieEntity>) -> Unit,
        onError: () -> Unit
    ) {
        remoteSource.getUpcomingMovies(page, onSuccess, onError)
    }

}
