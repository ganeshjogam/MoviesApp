package com.ganesh.topratedmovies.presentation

data class TopRatedMovieItemViewData(
    val id: Long,
    val title: String,
    val overview: String,
    val posterPath: String,
    val backdropPath: String,
    val rating: Float,
    val releaseDate: String
)