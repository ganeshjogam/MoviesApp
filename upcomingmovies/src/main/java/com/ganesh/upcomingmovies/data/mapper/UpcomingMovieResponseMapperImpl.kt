package com.ganesh.upcomingmovies.data.mapper

import com.ganesh.upcomingmovies.data.entity.UpcomingMoviesResponseEntity
import com.ganesh.upcomingmovies.domain.model.UpcomingMovieModel
import com.ganesh.upcomingmovies.domain.model.UpcomingMovieResponseModel

class UpcomingMovieResponseMapperImpl : UpcomingMovieResponseMapper {
    override fun toMovieListModel(moviesResponseEntity: UpcomingMoviesResponseEntity): UpcomingMovieResponseModel {
        val movieList = mutableListOf<UpcomingMovieModel>()
        moviesResponseEntity.movies.forEach {
            movieList.add(
                UpcomingMovieModel(
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
        return UpcomingMovieResponseModel(movieList, moviesResponseEntity.totalPages)
    }
}