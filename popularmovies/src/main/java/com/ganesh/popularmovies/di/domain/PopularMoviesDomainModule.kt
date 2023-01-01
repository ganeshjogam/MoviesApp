package com.ganesh.popularmovies.di.domain

import com.ganesh.popularmovies.domain.repository.PopularMovieRepository
import com.ganesh.popularmovies.domain.usecase.GetPopularMoviesUseCase
import com.ganesh.popularmovies.domain.usecase.GetPopularMoviesUseCaseImpl
import dagger.Module
import dagger.Provides

@Module
class PopularMoviesDomainModule {
    @Provides
    fun providePopularMovieUseCase(repository: PopularMovieRepository): GetPopularMoviesUseCase =
        GetPopularMoviesUseCaseImpl(repository)
}