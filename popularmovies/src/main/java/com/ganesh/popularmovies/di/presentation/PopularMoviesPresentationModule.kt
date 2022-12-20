package com.ganesh.popularmovies.di.presentation

import com.ganesh.core.IOScope
import com.ganesh.popularmovies.domain.usecase.GetPopularMoviesUseCase
import com.ganesh.popularmovies.presentation.mapper.PopularMovieMapperImpl
import com.ganesh.popularmovies.presentation.PopularMovieViewData
import com.ganesh.popularmovies.presentation.PopularMoviesViewModel
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
            mapper = PopularMovieMapperImpl()
        )
    }
}