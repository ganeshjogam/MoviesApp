package com.ganesh.topratedmovies.data.mapper

import com.ganesh.topratedmovies.data.entity.TopRatedMoviesResponseEntity
import com.ganesh.topratedmovies.domain.model.TopRatedMovieResponseModel

interface TopRatedMovieResponseMapper {
    fun toMovieListModel(moviesResponseEntity: TopRatedMoviesResponseEntity): TopRatedMovieResponseModel
}