package com.ganesh.moviesapp.di.domain

import com.ganesh.moviesapp.domain.repository.MovieRepository
import com.ganesh.moviesapp.domain.usecase.*
import dagger.Module
import dagger.Provides

@Module
class MainActivityDomainModule {
    @Provides
    fun providePopularMovieUseCase(repository: MovieRepository): GetPopularMoviesUseCase =
        GetPopularMoviesUseCaseImpl(repository)

    @Provides
    fun provideUpcomingMovieUseCase(repository: MovieRepository): GetUpcomingMoviesUseCase =
        GetUpcomingMoviesUseCaseImpl(repository)

    @Provides
    fun provideTopRatedMovieUseCase(repository: MovieRepository): GetTopRatedMoviesUseCase =
        GetTopRatedMoviesUseCaseImpl(repository)
}