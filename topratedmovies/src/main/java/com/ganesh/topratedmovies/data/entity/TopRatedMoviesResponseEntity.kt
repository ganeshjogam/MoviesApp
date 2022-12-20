package com.ganesh.topratedmovies.data.entity

import com.google.gson.annotations.SerializedName

data class TopRatedMoviesResponseEntity(
    @SerializedName("page") val page: Int,
    @SerializedName("results") val movies: List<TopRatedMovieEntity>,
    @SerializedName("total_pages") val totalPages: Int
)