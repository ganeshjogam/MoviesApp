package com.ganesh.upcomingmovies.domain.usecase

import com.ganesh.core.BaseFailure
import com.ganesh.core.BaseResult
import com.ganesh.upcomingmovies.domain.model.UpcomingMovieResponseModel
import com.ganesh.upcomingmovies.domain.repository.UpcomingMovieRepository
import kotlin.coroutines.CoroutineContext

class GetUpcomingMoviesUseCaseImpl(
    private val repository: UpcomingMovieRepository,
) : GetUpcomingMoviesUseCase {
    override suspend fun invoke(
        params: UpcomingMoviesRequest,
        context: CoroutineContext
    ): BaseResult<BaseFailure, UpcomingMovieResponseModel> = repository.getPopularMovies(page = params.page)
}