package com.ganesh.topratedmovies.presentation.mapper

import com.ganesh.topratedmovies.domain.model.TopRatedMovieModel
import com.ganesh.topratedmovies.presentation.TopRatedMovieItemViewData

class TopRatedMovieMapperImpl : TopRatedMovieMapper {
    override fun toViewData(movies: List<TopRatedMovieModel>): List<TopRatedMovieItemViewData> =
        movies.map {
           TopRatedMovieItemViewData(
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