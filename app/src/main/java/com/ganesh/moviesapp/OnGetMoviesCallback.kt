package com.ganesh.moviesapp

import com.ganesh.moviesapp.data.entity.MovieEntity

interface OnGetMoviesCallback {
    fun onSuccess(movies: List<MovieEntity?>?)
    fun onError()
}
