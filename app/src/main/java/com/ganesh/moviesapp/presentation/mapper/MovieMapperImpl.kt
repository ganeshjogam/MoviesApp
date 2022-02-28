package com.ganesh.moviesapp.presentation.mapper

import com.ganesh.moviesapp.domain.model.MovieModel
import com.ganesh.moviesapp.presentation.MovieViewData

class MovieMapperImpl : MovieMapper {
    override fun toViewData(movies: List<MovieModel>): List<MovieViewData> =
        movies.map {
            MovieViewData(
                id = it.id,
                title = it.title,
                overview = it.overview,
                posterPath = it.posterPath,
                backdropPath = it.backdropPath,
                rating = it.rating,
                releaseDate = it.releaseDate
            )
        }

}