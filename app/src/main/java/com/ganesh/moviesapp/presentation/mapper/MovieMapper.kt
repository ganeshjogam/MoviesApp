package com.ganesh.moviesapp.presentation.mapper

import com.ganesh.moviesapp.domain.model.MovieModel
import com.ganesh.moviesapp.presentation.MovieViewData

interface MovieMapper {
    fun toViewData(movies: List<MovieModel>): List<MovieViewData>
}