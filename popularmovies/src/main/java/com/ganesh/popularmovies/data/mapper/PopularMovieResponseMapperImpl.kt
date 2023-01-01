package com.ganesh.popularmovies.data.mapper

import com.ganesh.popularmovies.data.entity.PopularMoviesResponseEntity
import com.ganesh.popularmovies.domain.model.PopularMovieModel
import com.ganesh.popularmovies.domain.model.PopularMovieResponseModel

class PopularMovieResponseMapperImpl : PopularMovieResponseMapper {
    override fun toMovieListModel(moviesResponseEntity: PopularMoviesResponseEntity): PopularMovieResponseModel {
        val movieList = mutableListOf<PopularMovieModel>()
        moviesResponseEntity.movies.forEach {
            movieList.add(
                PopularMovieModel(
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
        return PopularMovieResponseModel(movieList, moviesResponseEntity.totalPages)
    }
}