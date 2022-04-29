package com.ganesh.moviesapp.domain.usecase

import com.ganesh.moviesapp.core.BaseUseCase
import com.ganesh.moviesapp.domain.model.MovieModel

interface GetPopularMoviesUseCase : BaseUseCase<PopularMoviesRequest, List<MovieModel>>

data class PopularMoviesRequest(
    val page: Int
)