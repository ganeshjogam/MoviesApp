package com.ganesh.moviesapp.domain.usecase

import com.ganesh.moviesapp.domain.repository.MovieRepository

class GetTopRatedMoviesUseCaseImpl(val repository: MovieRepository): GetTopRatedMoviesUseCase {
    override fun invoke(params: TopRatedMoviesRequest) {
        repository.getTopRatedMovies(
            page = params.page,
            onSuccess = params.onSuccess,
            onError = params.onError
        )
    }
}