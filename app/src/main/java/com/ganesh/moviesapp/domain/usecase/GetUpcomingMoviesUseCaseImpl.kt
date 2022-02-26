package com.ganesh.moviesapp.domain.usecase

import com.ganesh.moviesapp.domain.repository.MovieRepository

class GetUpcomingMoviesUseCaseImpl(val repository: MovieRepository):GetUpcomingMoviesUseCase {
    override fun invoke(params: UpcomingMoviesRequest) {
        repository.getUpcomingMovies(
            page = params.page,
            onSuccess = params.onSuccess,
            onError = params.onError
        )
    }
}