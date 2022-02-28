package com.ganesh.moviesapp.domain.usecase

import com.ganesh.moviesapp.domain.repository.MovieRepository

class GetPopularMoviesUseCaseImpl(
    private val repository: MovieRepository,
) : GetPopularMoviesUseCase {
    override fun invoke(params: PopularMoviesRequest): Unit {
        return repository.getPopularMovies(
            page = params.page,
            onSuccess = params.onSuccess,
            onError = { params.onError }
        )
    }
}