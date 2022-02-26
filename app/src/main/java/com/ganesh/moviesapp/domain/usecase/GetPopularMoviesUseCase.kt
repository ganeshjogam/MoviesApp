package com.ganesh.moviesapp.domain.usecase

import com.ganesh.moviesapp.core.BaseUseCaseWithCallback
import com.ganesh.moviesapp.data.entity.MovieEntity

interface GetPopularMoviesUseCase : BaseUseCaseWithCallback<PopularMoviesRequest>

data class PopularMoviesRequest(
    val page: Int,
    val onSuccess: (movies: List<MovieEntity>) -> Unit,
    val onError: () -> Unit
)