package com.ganesh.moviesapp.domain.usecase

import com.ganesh.core.BaseUseCase
import com.ganesh.moviesapp.domain.model.MovieResponseModel

interface GetTopRatedMoviesUseCase: BaseUseCase<TopRatedMoviesRequest, MovieResponseModel>

data class TopRatedMoviesRequest(
    val page: Int
)