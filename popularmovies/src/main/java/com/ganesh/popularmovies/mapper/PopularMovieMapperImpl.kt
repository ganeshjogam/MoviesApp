package com.ganesh.popularmovies.mapper

import com.ganesh.popularmovies.domain.model.PopularMovieModel
import com.ganesh.popularmovies.presentation.PopularMovieItemViewData

class PopularMovieMapperImpl : PopularMovieMapper {
    override fun toViewData(movies: List<PopularMovieModel>): List<PopularMovieItemViewData> =
        movies.map {
            PopularMovieItemViewData(
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