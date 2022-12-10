package com.ganesh.moviesapp.domain.usecase

import com.ganesh.moviesapp.core.BaseFailure
import com.ganesh.moviesapp.core.BaseResult
import com.ganesh.moviesapp.domain.model.MovieResponseModel
import com.ganesh.moviesapp.domain.repository.MovieRepository
import kotlin.coroutines.CoroutineContext

class GetTopRatedMoviesUseCaseImpl(val repository: MovieRepository) : GetTopRatedMoviesUseCase {
    override suspend fun invoke(
        params: TopRatedMoviesRequest,
        context: CoroutineContext
    ): BaseResult<BaseFailure, MovieResponseModel> {
        return repository.getTopRatedMovies(page = params.page)
    }
}