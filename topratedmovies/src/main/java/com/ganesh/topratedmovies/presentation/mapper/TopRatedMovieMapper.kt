package com.ganesh.topratedmovies.presentation.mapper

import com.ganesh.topratedmovies.domain.model.TopRatedMovieModel
import com.ganesh.topratedmovies.presentation.TopRatedMovieItemViewData

interface TopRatedMovieMapper {
    fun toViewData(movies: List<TopRatedMovieModel>): List<TopRatedMovieItemViewData>
}