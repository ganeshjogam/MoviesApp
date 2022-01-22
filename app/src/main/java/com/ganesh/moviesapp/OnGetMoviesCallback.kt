package com.ganesh.moviesapp

interface OnGetMoviesCallback {
    fun onSuccess(movies: List<Movie?>?)
    fun onError()
}
