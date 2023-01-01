package com.ganesh.topratedmovies.data.mapper

import com.ganesh.topratedmovies.data.entity.TopRatedMoviesResponseEntity
import com.ganesh.topratedmovies.domain.model.TopRatedMovieModel
import com.ganesh.topratedmovies.domain.model.TopRatedMovieResponseModel

class TopRatedMovieResponseMapperImpl : TopRatedMovieResponseMapper {
    override fun toMovieListModel(moviesResponseEntity: TopRatedMoviesResponseEntity): TopRatedMovieResponseModel {
        val movieList = mutableListOf<TopRatedMovieModel>()
        moviesResponseEntity.movies.forEach {
            movieList.add(
                TopRatedMovieModel(
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
        return TopRatedMovieResponseModel(movieList, moviesResponseEntity.totalPages)
    }
}