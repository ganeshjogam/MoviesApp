package com.ganesh.topratedmovies.domain.usecase

import com.ganesh.core.BaseFailure
import com.ganesh.core.BaseResult
import com.ganesh.topratedmovies.domain.model.TopRatedMovieResponseModel
import com.ganesh.topratedmovies.domain.repository.TopRatedMovieRepository
import kotlin.coroutines.CoroutineContext

class GetTopRatedMoviesUseCaseImpl(
    private val repository: TopRatedMovieRepository,
) : GetTopRatedMoviesUseCase {
    override suspend fun invoke(
        params: TopRatedMoviesRequest,
        context: CoroutineContext
    ): BaseResult<BaseFailure, TopRatedMovieResponseModel> = repository.getPopularMovies(page = params.page)
}