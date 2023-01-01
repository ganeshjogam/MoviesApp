package com.ganesh.upcomingmovies.domain.model

data class UpcomingMovieModel(
    val id: Long,
    val title: String,
    val overview: String,
    val posterPath: String,
    val backdropPath: String,
    val rating: Float,
    val releaseDate: String
)