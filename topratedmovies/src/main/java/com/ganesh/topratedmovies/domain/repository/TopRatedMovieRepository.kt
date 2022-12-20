package com.ganesh.topratedmovies.domain.repository

import com.ganesh.core.BaseFailure
import com.ganesh.core.BaseResult
import com.ganesh.topratedmovies.domain.model.TopRatedMovieResponseModel

interface TopRatedMovieRepository {
    suspend fun getPopularMovies(
        page: Int
    ): BaseResult<BaseFailure, TopRatedMovieResponseModel>
}