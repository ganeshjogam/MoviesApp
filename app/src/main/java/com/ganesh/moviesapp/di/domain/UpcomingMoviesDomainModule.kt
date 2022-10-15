package com.ganesh.moviesapp.di.domain

import com.ganesh.moviesapp.domain.repository.MovieRepository
import com.ganesh.moviesapp.domain.usecase.GetUpcomingMoviesUseCase
import com.ganesh.moviesapp.domain.usecase.GetUpcomingMoviesUseCaseImpl
import dagger.Module
import dagger.Provides

@Module
class UpcomingMoviesDomainModule {
    @Provides
    fun provideUpcomingMovieUseCase(repository: MovieRepository): GetUpcomingMoviesUseCase =
        GetUpcomingMoviesUseCaseImpl(repository)
}