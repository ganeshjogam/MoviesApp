package com.ganesh.moviesapp.di.domain

import com.ganesh.moviesapp.domain.repository.MovieRepository
import com.ganesh.moviesapp.domain.usecase.GetTopRatedMoviesUseCase
import com.ganesh.moviesapp.domain.usecase.GetTopRatedMoviesUseCaseImpl
import dagger.Module
import dagger.Provides

@Module
class TopRatedMoviesDomainModule {
    @Provides
    fun provideTopRatedMovieUseCase(repository: MovieRepository): GetTopRatedMoviesUseCase =
        GetTopRatedMoviesUseCaseImpl(repository)
}