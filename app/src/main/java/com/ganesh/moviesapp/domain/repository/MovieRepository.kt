package com.ganesh.moviesapp.domain.repository

import com.ganesh.moviesapp.data.entity.MovieEntity

interface MovieRepository {
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