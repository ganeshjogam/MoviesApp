package com.ganesh.moviesapp.data.entity

import com.google.gson.annotations.SerializedName

data class MoviesResponseEntity(
    @SerializedName("page") val page: Int,
    @SerializedName("results") val movies: List<MovieEntity>,
    @SerializedName("total_pages") val totalPages: Int
)