package com.ganesh.moviesapp.data.sources.remote

import com.ganesh.moviesapp.core.BaseFailure
import com.ganesh.moviesapp.core.BaseResult
import com.ganesh.moviesapp.core.request
import com.ganesh.moviesapp.data.sources.remote.api.Api
import com.ganesh.moviesapp.data.entity.MoviesResponseEntity
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

class MovieRemoteSourceImpl(private val api: Api) : MovieRemoteSource {
    override suspend fun getPopularMovies(
        page: Int
    ): BaseResult<BaseFailure, MoviesResponseEntity> =
        request(
            { api.getPopularMovies(page = page)},
            { entity, _ -> entity.body()!!}
        )

    override fun getTopRatedMovies(
        page: Int,
        onSuccess: (movieResponse: MoviesResponseEntity) -> Unit,
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
                            onSuccess.invoke(responseBody)
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
        onSuccess: (movieResponse: MoviesResponseEntity) -> Unit,
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
                            onSuccess.invoke(responseBody)
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