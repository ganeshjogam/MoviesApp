package com.ganesh.upcomingmovies.domain.usecase

import com.ganesh.core.BaseUseCase
import com.ganesh.upcomingmovies.domain.model.UpcomingMovieResponseModel

interface GetUpcomingMoviesUseCase : BaseUseCase<UpcomingMoviesRequest, UpcomingMovieResponseModel>

data class UpcomingMoviesRequest(
    val page: Int
)