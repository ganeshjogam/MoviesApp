package com.ganesh.moviesapp.domain.usecase

import com.ganesh.core.BaseFailure
import com.ganesh.core.BaseResult
import com.ganesh.moviesapp.domain.model.MovieResponseModel
import com.ganesh.moviesapp.domain.repository.MovieRepository
import kotlin.coroutines.CoroutineContext

class GetPopularMoviesUseCaseImpl(
    private val repository: MovieRepository,
) : GetPopularMoviesUseCase {
    override suspend fun invoke(
        params: PopularMoviesRequest,
        context: CoroutineContext
    ): BaseResult<BaseFailure, MovieResponseModel> = repository.getPopularMovies(page = params.page)
}