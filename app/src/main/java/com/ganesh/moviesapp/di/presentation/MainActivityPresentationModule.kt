package com.ganesh.moviesapp.di.presentation

import com.ganesh.moviesapp.core.IOScope
import com.ganesh.moviesapp.domain.usecase.GetPopularMoviesUseCase
import com.ganesh.moviesapp.domain.usecase.GetTopRatedMoviesUseCase
import com.ganesh.moviesapp.domain.usecase.GetUpcomingMoviesUseCase
import com.ganesh.moviesapp.presentation.MainViewModel
import com.ganesh.moviesapp.presentation.MovieViewData
import com.ganesh.moviesapp.presentation.mapper.MovieMapperImpl
import dagger.Module
import dagger.Provides

@Module
class MainActivityPresentationModule {
    @Provides
    fun provideMainViewModel(
        getPopularMoviesUseCase: GetPopularMoviesUseCase,
        getTopRatedMoviesUseCase: GetTopRatedMoviesUseCase,
        getUpcomingMoviesUseCase: GetUpcomingMoviesUseCase
    ): MainViewModel =
        MainViewModel(
            getPopularMoviesUseCase = getPopularMoviesUseCase,
            getTopRatedMoviesUseCase = getTopRatedMoviesUseCase,
            getUpcomingMoviesUseCase = getUpcomingMoviesUseCase,
            mapper = MovieMapperImpl(),
            scope = IOScope(),
            data = MovieViewData()
        )
}