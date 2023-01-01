package com.ganesh.upcomingmovies.data.mapper

import com.ganesh.upcomingmovies.data.entity.UpcomingMoviesResponseEntity
import com.ganesh.upcomingmovies.domain.model.UpcomingMovieResponseModel

interface UpcomingMovieResponseMapper {
    fun toMovieListModel(moviesResponseEntity: UpcomingMoviesResponseEntity): UpcomingMovieResponseModel
}