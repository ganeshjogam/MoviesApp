package com.ganesh.topratedmovies.di.data

import com.ganesh.topratedmovies.data.mapper.TopRatedMovieResponseMapper
import com.ganesh.topratedmovies.data.mapper.TopRatedMovieResponseMapperImpl
import com.ganesh.topratedmovies.data.repository.TopRatedMoviesRepositoryImpl
import com.ganesh.topratedmovies.data.sources.remote.TopRatedMovieRemoteSource
import com.ganesh.topratedmovies.data.sources.remote.TopRatedMovieRemoteSourceImpl
import com.ganesh.topratedmovies.data.sources.remote.api.TopRatedMoviesApi
import com.ganesh.topratedmovies.domain.repository.TopRatedMovieRepository
import dagger.Module
import dagger.Provides
import retrofit2.Retrofit

@Module
class TopRatedMoviesDataModule {
    @Provides
    fun providePopularMovieRepository(
        remoteSource: TopRatedMovieRemoteSource,
        mapper: TopRatedMovieResponseMapper
    )
            : TopRatedMovieRepository = TopRatedMoviesRepositoryImpl(remoteSource, mapper)


    @Provides
    fun providePopularMovieRemoteSource(api: TopRatedMoviesApi): TopRatedMovieRemoteSource =
        TopRatedMovieRemoteSourceImpl(api)

    @Provides
    fun providePopularMovieResponseMapper(): TopRatedMovieResponseMapper =
        TopRatedMovieResponseMapperImpl()

    @Provides
    fun provideRestApi(retrofit: Retrofit): TopRatedMoviesApi {
        return retrofit.create(TopRatedMoviesApi::class.java)
    }
}