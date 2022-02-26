package com.ganesh.moviesapp.data.sources.remote

import com.ganesh.moviesapp.data.sources.remote.api.Api
import com.ganesh.moviesapp.data.entity.MovieEntity
import com.ganesh.moviesapp.data.entity.MoviesResponseEntity
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

class MovieRemoteSourceImpl(val api: Api) : MovieRemoteSource {
    override fun getPopularMovies(
        page: Int,
        onSuccess: (movies: List<MovieEntity>) -> Unit,
        onError: () -> Unit
    ) {
        api.getPopularMovies(page = page)
            .enqueue(object : Callback<MoviesResponseEntity> {
                override fun onResponse(
                    call: Call<MoviesResponseEntity>,
                    response: Response<MoviesResponseEntity>
                ) {
                    if (response.isSuccessful) {
                        val responseBody = response.body()

                        if (responseBody != null) {
                            onSuccess.invoke(responseBody.movies)
                        } else {
                            onError.invoke()
                        }
                    } else {
                        onError.invoke()
                    }
                }

                override fun onFailure(call: Call<MoviesResponseEntity>, t: Throwable) {
                    onError.invoke()
                }
            })
    }

    override fun getTopRatedMovies(
        page: Int,
        onSuccess: (movies: List<MovieEntity>) -> Unit,
        onError: () -> Unit
    ) {
        api.getTopRatedMovies(page = page)
            .enqueue(object : Callback<MoviesResponseEntity> {
                override fun onResponse(
                    call: Call<MoviesResponseEntity>,
                    response: Response<MoviesResponseEntity>
                ) {
                    if (response.isSuccessful) {
                        val responseBody = response.body()

                        if (responseBody != null) {
                            onSuccess.invoke(responseBody.movies)
                        } else {
                            onError.invoke()
                        }
                    } else {
                        onError.invoke()
                    }
                }

                override fun onFailure(call: Call<MoviesResponseEntity>, t: Throwable) {
                    onError.invoke()
                }
            })
    }

    override fun getUpcomingMovies(
        page: Int,
        onSuccess: (movies: List<MovieEntity>) -> Unit,
        onError: () -> Unit
    ) {
        api.getUpcomingMovies(page = page)
            .enqueue(object : Callback<MoviesResponseEntity> {
                override fun onResponse(
                    call: Call<MoviesResponseEntity>,
                    response: Response<MoviesResponseEntity>
                ) {
                    if (response.isSuccessful) {
                        val responseBody = response.body()

                        if (responseBody != null) {
                            onSuccess.invoke(responseBody.movies)
                        } else {
                            onError.invoke()
                        }
                    } else {
                        onError.invoke()
                    }
                }

                override fun onFailure(call: Call<MoviesResponseEntity>, t: Throwable) {
                    onError.invoke()
                }
            })
    }
}