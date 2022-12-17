package com.ganesh.popularmovies.data.sources.remote.api

import com.ganesh.popularmovies.BuildConfig
import com.ganesh.popularmovies.data.entity.PopularMoviesResponseEntity
import retrofit2.Response
import retrofit2.http.GET
import retrofit2.http.Query

interface PopularMoviesApi {

    @GET("movie/popular")
    suspend fun getPopularMovies(
        @Query("api_key") apiKey: String = BuildConfig.API_KEY,
        @Query("page") page: Int
    ): Response<PopularMoviesResponseEntity>
}
