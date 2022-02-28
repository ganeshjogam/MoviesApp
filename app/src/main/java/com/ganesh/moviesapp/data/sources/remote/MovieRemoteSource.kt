package com.ganesh.moviesapp.data.sources.remote

import com.ganesh.moviesapp.data.entity.MovieEntity
import com.ganesh.moviesapp.data.entity.MoviesResponseEntity

interface MovieRemoteSource {
    fun getPopularMovies(
        page: Int,
        onSuccess: (movieResponse: MoviesResponseEntity) -> Unit,
        onError: () -> Unit
    )

    fun getTopRatedMovies(
        page: Int,
        onSuccess: (movieResponse: MoviesResponseEntity) -> Unit,
        onError: () -> Unit
    )

    fun getUpcomingMovies(
        page: Int,
        onSuccess: (movieResponse: MoviesResponseEntity) -> Unit,
        onError: () -> Unit
    )
}