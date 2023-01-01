package com.ganesh.popularmovies.domain.repository

import com.ganesh.core.BaseFailure
import com.ganesh.core.BaseResult
import com.ganesh.popularmovies.domain.model.PopularMovieResponseModel

interface PopularMovieRepository {
    suspend fun getPopularMovies(
        page: Int
    ): BaseResult<BaseFailure, PopularMovieResponseModel>
}