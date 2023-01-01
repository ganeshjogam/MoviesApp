package com.ganesh.popularmovies.domain.usecase

import com.ganesh.core.BaseUseCase
import com.ganesh.popularmovies.domain.model.PopularMovieResponseModel

interface GetPopularMoviesUseCase : BaseUseCase<PopularMoviesRequest, PopularMovieResponseModel>

data class PopularMoviesRequest(
    val page: Int
)