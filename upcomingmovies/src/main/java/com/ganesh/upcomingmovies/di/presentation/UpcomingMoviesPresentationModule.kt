package com.ganesh.upcomingmovies.di.presentation

import com.ganesh.core.IOScope
import com.ganesh.upcomingmovies.domain.usecase.GetUpcomingMoviesUseCase
import com.ganesh.upcomingmovies.presentation.UpcomingMovieViewData
import com.ganesh.upcomingmovies.presentation.UpcomingMoviesViewModel
import com.ganesh.upcomingmovies.presentation.mapper.UpcomingMovieMapperImpl
import dagger.Module
import dagger.Provides

@Module
class UpcomingMoviesPresentationModule {
    @Provides
    fun providePopularMovieViewModel(
        getPopularMoviesUseCase: GetUpcomingMoviesUseCase
    ): UpcomingMoviesViewModel {
        return UpcomingMoviesViewModel(
            scope = IOScope(),
            data = UpcomingMovieViewData(),
            mapper = UpcomingMovieMapperImpl(),
            getUpcomingMoviesUseCase = getPopularMoviesUseCase
        )
    }
}