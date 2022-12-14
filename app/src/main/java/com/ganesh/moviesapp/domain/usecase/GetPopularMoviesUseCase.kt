package com.ganesh.moviesapp.domain.usecase

import com.ganesh.core.BaseUseCase
import com.ganesh.moviesapp.domain.model.MovieResponseModel

interface GetPopularMoviesUseCase : BaseUseCase<PopularMoviesRequest, MovieResponseModel>

data class PopularMoviesRequest(
    val page: Int
)