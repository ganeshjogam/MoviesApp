package com.ganesh.topratedmovies.di.domain

import com.ganesh.topratedmovies.domain.repository.TopRatedMovieRepository
import com.ganesh.topratedmovies.domain.usecase.GetTopRatedMoviesUseCase
import com.ganesh.topratedmovies.domain.usecase.GetTopRatedMoviesUseCaseImpl
import dagger.Module
import dagger.Provides

@Module
class TopRatedMoviesDomainModule {
    @Provides
    fun providePopularMovieUseCase(repository: TopRatedMovieRepository): GetTopRatedMoviesUseCase =
        GetTopRatedMoviesUseCaseImpl(repository)
}