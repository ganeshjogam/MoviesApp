package com.ganesh.popularmovies.di.data

import com.ganesh.popularmovies.data.mapper.PopularMovieResponseMapper
import com.ganesh.popularmovies.data.mapper.PopularMovieResponseMapperImpl
import com.ganesh.popularmovies.data.repository.PopularMoviesRepositoryImpl
import com.ganesh.popularmovies.data.sources.local.PopularMovieLocalSource
import com.ganesh.popularmovies.data.sources.local.PopularMovieLocalSourceImpl
import com.ganesh.popularmovies.data.sources.remote.PopularMovieRemoteSource
import com.ganesh.popularmovies.data.sources.remote.PopularMovieRemoteSourceImpl
import com.ganesh.popularmovies.data.sources.remote.api.PopularMoviesApi
import com.ganesh.popularmovies.domain.repository.PopularMovieRepository
import dagger.Module
import dagger.Provides
import retrofit2.Retrofit

@Module
class PopularMoviesDataModule {
    @Provides
    fun providePopularMovieRepository(
        localSource: PopularMovieLocalSource,
        remoteSource: PopularMovieRemoteSource,
        mapper: PopularMovieResponseMapper
    )
            : PopularMovieRepository = PopularMoviesRepositoryImpl(localSource, remoteSource, mapper)

    @Provides
    fun providePopularMovieLocalSource(): PopularMovieLocalSource = PopularMovieLocalSourceImpl()

    @Provides
    fun providePopularMovieRemoteSource(api: PopularMoviesApi): PopularMovieRemoteSource = PopularMovieRemoteSourceImpl(api)

    @Provides
    fun providePopularMovieResponseMapper(): PopularMovieResponseMapper = PopularMovieResponseMapperImpl()

    @Provides
    fun provideRestApi(retrofit: Retrofit): PopularMoviesApi {
        return retrofit.create(PopularMoviesApi::class.java)
    }
}