package com.ganesh.upcomingmovies.data.sources.remote.api

import com.ganesh.upcomingmovies.data.entity.UpcomingMoviesResponseEntity
import retrofit2.Response
import retrofit2.http.GET
import retrofit2.http.Query
import com.ganesh.upcomingmovies.BuildConfig

interface UpcomingMoviesApi {

    @GET("movie/upcoming")
    suspend fun getUpcomingMovies(
        @Query("api_key") apiKey: String = BuildConfig.API_KEY,
        @Query("page") page: Int
    ): Response<UpcomingMoviesResponseEntity>
}
