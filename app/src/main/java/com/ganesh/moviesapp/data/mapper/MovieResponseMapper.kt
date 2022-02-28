package com.ganesh.moviesapp.data.mapper

import com.ganesh.moviesapp.data.entity.MoviesResponseEntity
import com.ganesh.moviesapp.domain.model.MovieModel

interface MovieResponseMapper {
    fun toMovieListModel(moviesResponseEntity: MoviesResponseEntity): List<MovieModel>
}