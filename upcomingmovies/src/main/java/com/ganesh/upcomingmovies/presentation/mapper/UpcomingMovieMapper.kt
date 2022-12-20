package com.ganesh.upcomingmovies.presentation.mapper

import com.ganesh.upcomingmovies.domain.model.UpcomingMovieModel
import com.ganesh.upcomingmovies.presentation.UpcomingMovieItemViewData

interface UpcomingMovieMapper {
    fun toViewData(movies: List<UpcomingMovieModel>): List<UpcomingMovieItemViewData>
}