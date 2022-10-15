package com.ganesh.moviesapp.di.data

import com.ganesh.moviesapp.data.mapper.MovieResponseMapper
import com.ganesh.moviesapp.data.mapper.MovieResponseMapperImpl
import com.ganesh.moviesapp.data.repository.MoviesRepositoryImpl
import com.ganesh.moviesapp.data.sources.local.MovieLocalSource
import com.ganesh.moviesapp.data.sources.local.MovieLocalSourceImpl
import com.ganesh.moviesapp.data.sources.remote.MovieRemoteSource
import com.ganesh.moviesapp.data.sources.remote.MovieRemoteSourceImpl
import com.ganesh.moviesapp.data.sources.remote.api.Api
import com.ganesh.moviesapp.domain.repository.MovieRepository
import dagger.Module
import dagger.Provides

@Module
class UpcomingMoviesDataModule {
    @Provides
    fun provideMovieRepository(
        localSource: MovieLocalSource,
        remoteSource: MovieRemoteSource,
        mapper: MovieResponseMapper
    )
            : MovieRepository = MoviesRepositoryImpl(localSource, remoteSource, mapper)

    @Provides
    fun provideMovieLocalSource(): MovieLocalSource = MovieLocalSourceImpl()

    @Provides
    fun provideMovieRemoteSource(api: Api): MovieRemoteSource = MovieRemoteSourceImpl(api)

    @Provides
    fun provideMovieResponseMapper(): MovieResponseMapper = MovieResponseMapperImpl()
}