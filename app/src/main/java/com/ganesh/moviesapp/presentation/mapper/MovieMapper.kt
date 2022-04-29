package com.ganesh.moviesapp.presentation.mapper

import com.ganesh.moviesapp.domain.model.MovieModel
import com.ganesh.moviesapp.presentation.MovieItemViewData

interface MovieMapper {
    fun toViewData(movies: List<MovieModel>): List<MovieItemViewData>
}