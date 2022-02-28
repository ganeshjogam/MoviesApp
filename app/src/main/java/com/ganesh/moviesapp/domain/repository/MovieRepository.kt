package com.ganesh.moviesapp.domain.repository

import com.ganesh.moviesapp.domain.model.MovieModel

interface MovieRepository {
    fun getPopularMovies(
        page: Int,
        onSuccess: (movies: List<MovieModel>) -> Unit,
        onError: () -> Unit
    )

    fun getTopRatedMovies(
        page: Int,
        onSuccess: (movies: List<MovieModel>) -> Unit,
        onError: () -> Unit
    )

    fun getUpcomingMovies(
        page: Int,
        onSuccess: (movies: List<MovieModel>) -> Unit,
        onError: () -> Unit
    )
}