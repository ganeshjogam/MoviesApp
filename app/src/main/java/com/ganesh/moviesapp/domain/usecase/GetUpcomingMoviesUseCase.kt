package com.ganesh.moviesapp.domain.usecase

import com.ganesh.moviesapp.core.BaseUseCaseWithCallback
import com.ganesh.moviesapp.domain.model.MovieModel

interface GetUpcomingMoviesUseCase: BaseUseCaseWithCallback<UpcomingMoviesRequest>

data class UpcomingMoviesRequest(
    val page: Int,
    val onSuccess: (movies: List<MovieModel>) -> Unit,
    val onError: () -> Unit
)