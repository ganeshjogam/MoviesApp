package com.ganesh.popularmovies.mapper

import com.ganesh.popularmovies.domain.model.PopularMovieModel
import com.ganesh.popularmovies.presentation.PopularMovieItemViewData

interface PopularMovieMapper {
    fun toViewData(movies: List<PopularMovieModel>): List<PopularMovieItemViewData>
}