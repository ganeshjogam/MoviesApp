package com.ganesh.moviesapp.data.mapper

import com.ganesh.moviesapp.data.entity.MoviesResponseEntity
import com.ganesh.moviesapp.domain.model.MovieModel

class MovieResponseMapperImpl : MovieResponseMapper {
    override fun toMovieListModel(moviesResponseEntity: MoviesResponseEntity): List<MovieModel> {
        val movieList = mutableListOf<MovieModel>()
        moviesResponseEntity.movies.forEach {
            movieList.add(
                MovieModel(
                    id = it.id,
                    title = it.title,
                    posterPath = it.posterPath,
                    overview = it.overview,
                    backdropPath = it.backdropPath ?: "",
                    rating = it.rating,
                    releaseDate = it.releaseDate
                )
            )
        }
        return movieList
    }
}