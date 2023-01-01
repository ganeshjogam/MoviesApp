package com.ganesh.topratedmovies.domain.usecase

import com.ganesh.core.BaseUseCase
import com.ganesh.topratedmovies.domain.model.TopRatedMovieResponseModel

interface GetTopRatedMoviesUseCase : BaseUseCase<TopRatedMoviesRequest, TopRatedMovieResponseModel>

data class TopRatedMoviesRequest(
    val page: Int
)