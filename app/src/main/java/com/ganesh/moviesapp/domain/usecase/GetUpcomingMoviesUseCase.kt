package com.ganesh.moviesapp.domain.usecase

import com.ganesh.core.BaseUseCase
import com.ganesh.moviesapp.domain.model.MovieResponseModel

interface GetUpcomingMoviesUseCase: BaseUseCase<UpcomingMoviesRequest, MovieResponseModel>

data class UpcomingMoviesRequest(
    val page: Int
)