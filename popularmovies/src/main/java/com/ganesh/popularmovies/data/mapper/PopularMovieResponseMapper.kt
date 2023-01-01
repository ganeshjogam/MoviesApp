package com.ganesh.popularmovies.data.mapper

import com.ganesh.popularmovies.data.entity.PopularMoviesResponseEntity
import com.ganesh.popularmovies.domain.model.PopularMovieResponseModel

interface PopularMovieResponseMapper {
    fun toMovieListModel(moviesResponseEntity: PopularMoviesResponseEntity): PopularMovieResponseModel
}