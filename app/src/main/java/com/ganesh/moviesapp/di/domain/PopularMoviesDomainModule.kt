package com.ganesh.moviesapp.di.domain

import com.ganesh.moviesapp.domain.repository.MovieRepository
import com.ganesh.moviesapp.domain.usecase.GetPopularMoviesUseCase
import com.ganesh.moviesapp.domain.usecase.GetPopularMoviesUseCaseImpl
import dagger.Module
import dagger.Provides

@Module
class PopularMoviesDomainModule {
    @Provides
    fun providePopularMovieUseCase(repository: MovieRepository): GetPopularMoviesUseCase =
        GetPopularMoviesUseCaseImpl(repository)
}