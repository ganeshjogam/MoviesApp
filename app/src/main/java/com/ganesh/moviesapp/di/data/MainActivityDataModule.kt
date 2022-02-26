package com.ganesh.moviesapp.di.data

import com.ganesh.moviesapp.data.sources.remote.api.Api
import com.ganesh.moviesapp.data.repository.MoviesRepositoryImpl
import com.ganesh.moviesapp.data.sources.local.MovieLocalSource
import com.ganesh.moviesapp.data.sources.local.MovieLocalSourceImpl
import com.ganesh.moviesapp.data.sources.remote.MovieRemoteSource
import com.ganesh.moviesapp.data.sources.remote.MovieRemoteSourceImpl
import com.ganesh.moviesapp.domain.repository.MovieRepository
import dagger.Module
import dagger.Provides

@Module
class MainActivityDataModule {
    @Provides
    fun provideMovieRepository(
        localSource: MovieLocalSource,
        remoteSource: MovieRemoteSource
    )
    : MovieRepository = MoviesRepositoryImpl(localSource, remoteSource)

    @Provides
    fun provideMovieLocalSource(): MovieLocalSource = MovieLocalSourceImpl()

    @Provides
    fun provideMovieRemoteSource(api: Api): MovieRemoteSource = MovieRemoteSourceImpl(api)
}