package com.ganesh.moviesapp.domain.repository

import com.ganesh.moviesapp.core.BaseFailure
import com.ganesh.moviesapp.core.BaseResult
import com.ganesh.moviesapp.domain.model.MovieResponseModel

interface MovieRepository {
    suspend fun getPopularMovies(
        page: Int
    ): BaseResult<BaseFailure, MovieResponseModel>

    suspend fun getTopRatedMovies(
        page: Int
    ): BaseResult<BaseFailure, MovieResponseModel>

    suspend fun getUpcomingMovies(
        page: Int
    ): BaseResult<BaseFailure, MovieResponseModel>
}