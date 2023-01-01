package com.ganesh.upcomingmovies.di.data

import com.ganesh.upcomingmovies.data.mapper.UpcomingMovieResponseMapper
import com.ganesh.upcomingmovies.data.mapper.UpcomingMovieResponseMapperImpl
import com.ganesh.upcomingmovies.data.repository.UpcomingMoviesRepositoryImpl
import com.ganesh.upcomingmovies.data.sources.remote.UpcomingMovieRemoteSource
import com.ganesh.upcomingmovies.data.sources.remote.UpcomingMovieRemoteSourceImpl
import com.ganesh.upcomingmovies.data.sources.remote.api.UpcomingMoviesApi
import com.ganesh.upcomingmovies.domain.repository.UpcomingMovieRepository
import dagger.Module
import dagger.Provides
import retrofit2.Retrofit

@Module
class UpcomingMoviesDataModule {
    @Provides
    fun providePopularMovieRepository(
        remoteSource: UpcomingMovieRemoteSource,
        mapper: UpcomingMovieResponseMapper
    )
            : UpcomingMovieRepository = UpcomingMoviesRepositoryImpl( remoteSource, mapper)


    @Provides
    fun providePopularMovieRemoteSource(api: UpcomingMoviesApi): UpcomingMovieRemoteSource = UpcomingMovieRemoteSourceImpl(api)

    @Provides
    fun providePopularMovieResponseMapper(): UpcomingMovieResponseMapper = UpcomingMovieResponseMapperImpl()

    @Provides
    fun provideRestApi(retrofit: Retrofit): UpcomingMoviesApi {
        return retrofit.create(UpcomingMoviesApi::class.java)
    }
}