package com.ganesh.moviesapp.domain.usecase

import com.ganesh.core.BaseFailure
import com.ganesh.core.BaseResult
import com.ganesh.moviesapp.domain.model.MovieResponseModel
import com.ganesh.moviesapp.domain.repository.MovieRepository
import kotlin.coroutines.CoroutineContext

class GetUpcomingMoviesUseCaseImpl(val repository: MovieRepository):GetUpcomingMoviesUseCase {
    override suspend fun invoke(
        params: UpcomingMoviesRequest,
        context: CoroutineContext
    ): BaseResult<BaseFailure, MovieResponseModel> {
        return repository.getUpcomingMovies(page = params.page)
    }
}