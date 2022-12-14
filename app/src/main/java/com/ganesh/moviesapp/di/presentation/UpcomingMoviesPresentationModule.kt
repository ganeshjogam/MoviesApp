package com.ganesh.moviesapp.di.presentation

import com.ganesh.core.IOScope
import com.ganesh.moviesapp.domain.usecase.GetUpcomingMoviesUseCase
import com.ganesh.moviesapp.presentation.mapper.MovieMapperImpl
import com.ganesh.moviesapp.presentation.upcomingmovies.UpcomingMovieViewData
import com.ganesh.moviesapp.presentation.upcomingmovies.UpcomingMoviesViewModel
import dagger.Module
import dagger.Provides

@Module
class UpcomingMoviesPresentationModule {
    @Provides
    fun provideUpcomingMovieViewModel(
        getUpcomingMoviesUseCase: GetUpcomingMoviesUseCase
    ): UpcomingMoviesViewModel {
        return UpcomingMoviesViewModel(
            scope = IOScope(),
            data = UpcomingMovieViewData(),
            getUpcomingMoviesUseCase = getUpcomingMoviesUseCase,
            mapper = MovieMapperImpl()
        )
    }
}