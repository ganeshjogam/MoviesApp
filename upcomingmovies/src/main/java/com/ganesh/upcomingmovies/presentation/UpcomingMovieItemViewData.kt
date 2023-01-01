package com.ganesh.upcomingmovies.presentation

data class UpcomingMovieItemViewData(
    val id: Long,
    val title: String,
    val overview: String,
    val posterPath: String,
    val backdropPath: String,
    val rating: Float,
    val releaseDate: String
)