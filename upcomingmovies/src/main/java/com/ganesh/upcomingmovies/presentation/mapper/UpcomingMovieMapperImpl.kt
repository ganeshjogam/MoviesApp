package com.ganesh.upcomingmovies.presentation.mapper

import com.ganesh.upcomingmovies.domain.model.UpcomingMovieModel
import com.ganesh.upcomingmovies.presentation.UpcomingMovieItemViewData

class UpcomingMovieMapperImpl : UpcomingMovieMapper {
    override fun toViewData(movies: List<UpcomingMovieModel>): List<UpcomingMovieItemViewData> =
        movies.map {
            UpcomingMovieItemViewData(
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