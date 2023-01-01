package com.ganesh.popularmovies.data.entity

import com.google.gson.annotations.SerializedName

data class PopularMoviesResponseEntity(
    @SerializedName("page") val page: Int,
    @SerializedName("results") val movies: List<PopularMovieEntity>,
    @SerializedName("total_pages") val totalPages: Int
)