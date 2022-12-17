package com.ganesh.popularmovies.domain.usecase

import com.ganesh.core.BaseFailure
import com.ganesh.core.BaseResult
import com.ganesh.popularmovies.domain.model.PopularMovieResponseModel
import com.ganesh.popularmovies.domain.repository.PopularMovieRepository
import kotlin.coroutines.CoroutineContext

class GetPopularMoviesUseCaseImpl(
    private val repository: PopularMovieRepository,
) : GetPopularMoviesUseCase {
    override suspend fun invoke(
        params: PopularMoviesRequest,
        context: CoroutineContext
    ): BaseResult<BaseFailure, PopularMovieResponseModel> = repository.getPopularMovies(page = params.page)
}