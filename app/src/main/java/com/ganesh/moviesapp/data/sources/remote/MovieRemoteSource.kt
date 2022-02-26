package com.ganesh.moviesapp.data.sources.remote

import com.ganesh.moviesapp.data.entity.MovieEntity

interface MovieRemoteSource {
    fun getPopularMovies(
        page: Int,
        onSuccess: (movies: List<MovieEntity>) -> Unit,
        onError: () -> Unit
    )

    fun getTopRatedMovies(
        page: Int,
        onSuccess: (movies: List<MovieEntity>) -> Unit,
        onError: () -> Unit
    )

    fun getUpcomingMovies(
        page: Int,
        onSuccess: (movies: List<MovieEntity>) -> Unit,
        onError: () -> Unit
    )
}