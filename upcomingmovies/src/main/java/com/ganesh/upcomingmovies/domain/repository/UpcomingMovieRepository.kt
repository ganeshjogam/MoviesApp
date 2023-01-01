package com.ganesh.upcomingmovies.domain.repository

import com.ganesh.core.BaseFailure
import com.ganesh.core.BaseResult
import com.ganesh.upcomingmovies.domain.model.UpcomingMovieResponseModel

interface UpcomingMovieRepository {
    suspend fun getPopularMovies(
        page: Int
    ): BaseResult<BaseFailure, UpcomingMovieResponseModel>
}