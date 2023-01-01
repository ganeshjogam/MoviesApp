package com.ganesh.upcomingmovies.data.entity

import com.google.gson.annotations.SerializedName

data class UpcomingMoviesResponseEntity(
    @SerializedName("page") val page: Int,
    @SerializedName("results") val movies: List<UpcomingMovieEntity>,
    @SerializedName("total_pages") val totalPages: Int
)