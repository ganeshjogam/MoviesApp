package com.ganesh.upcomingmovies.di.domain

import com.ganesh.upcomingmovies.domain.repository.UpcomingMovieRepository
import com.ganesh.upcomingmovies.domain.usecase.GetUpcomingMoviesUseCase
import com.ganesh.upcomingmovies.domain.usecase.GetUpcomingMoviesUseCaseImpl
import dagger.Module
import dagger.Provides

@Module
class UpcomingMoviesDomainModule {
    @Provides
    fun providePopularMovieUseCase(repository: UpcomingMovieRepository): GetUpcomingMoviesUseCase =
        GetUpcomingMoviesUseCaseImpl(repository)
}