package com.ganesh.topratedmovies.domain.model

data class TopRatedMovieModel(
    val id: Long,
    val title: String,
    val overview: String,
    val posterPath: String,
    val backdropPath: String,
    val rating: Float,
    val releaseDate: String
)