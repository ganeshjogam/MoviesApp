package com.ganesh.moviesapp.domain.usecase

import com.ganesh.moviesapp.core.BaseFailure
import com.ganesh.moviesapp.core.BaseResult
import com.ganesh.moviesapp.domain.model.MovieModel
import com.ganesh.moviesapp.domain.repository.MovieRepository
import kotlin.coroutines.CoroutineContext

class GetPopularMoviesUseCaseImpl(
    private val repository: MovieRepository,
) : GetPopularMoviesUseCase {
    override suspend fun invoke(
        params: PopularMoviesRequest,
        context: CoroutineContext
    ): BaseResult<BaseFailure, List<MovieModel>> = repository.getPopularMovies(page = params.page)
}