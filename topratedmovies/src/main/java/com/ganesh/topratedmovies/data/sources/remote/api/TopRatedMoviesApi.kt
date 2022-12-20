package com.ganesh.topratedmovies.data.sources.remote.api

import com.ganesh.topratedmovies.data.entity.TopRatedMoviesResponseEntity
import com.ganesh.topratedmovies.BuildConfig
import retrofit2.Response
import retrofit2.http.GET
import retrofit2.http.Query

interface TopRatedMoviesApi {

    @GET("movie/top_rated")
    suspend fun getTopRatedMovies(
        @Query("api_key") apiKey: String = BuildConfig.API_KEY,
        @Query("page") page: Int
    ): Response<TopRatedMoviesResponseEntity>
}
