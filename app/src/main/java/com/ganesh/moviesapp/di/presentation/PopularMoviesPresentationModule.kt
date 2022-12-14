package com.ganesh.moviesapp.di.presentation

import com.ganesh.core.IOScope
import com.ganesh.moviesapp.domain.usecase.GetPopularMoviesUseCase
import com.ganesh.moviesapp.presentation.mapper.MovieMapperImpl
import com.ganesh.moviesapp.presentation.popularmovies.PopularMovieViewData
import com.ganesh.moviesapp.presentation.popularmovies.PopularMoviesViewModel
import dagger.Module
import dagger.Provides

@Module
class PopularMoviesPresentationModule {
    @Provides
    fun providePopularMovieViewModel(
        getPopularMoviesUseCase: GetPopularMoviesUseCase
    ): PopularMoviesViewModel {
        return PopularMoviesViewModel(
            scope = IOScope(),
            data = PopularMovieViewData(),
            getPopularMoviesUseCase = getPopularMoviesUseCase,
            mapper = MovieMapperImpl()
        )
    }
}