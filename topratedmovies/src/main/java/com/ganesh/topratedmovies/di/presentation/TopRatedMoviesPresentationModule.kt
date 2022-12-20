package com.ganesh.topratedmovies.di.presentation

import com.ganesh.core.IOScope
import com.ganesh.topratedmovies.domain.usecase.GetTopRatedMoviesUseCase
import com.ganesh.topratedmovies.presentation.TopRatedMovieViewData
import com.ganesh.topratedmovies.presentation.TopRatedMoviesViewModel
import com.ganesh.topratedmovies.presentation.mapper.TopRatedMovieMapperImpl
import dagger.Module
import dagger.Provides

@Module
class TopRatedMoviesPresentationModule {
    @Provides
    fun providePopularMovieViewModel(
        getPopularMoviesUseCase: GetTopRatedMoviesUseCase
    ): TopRatedMoviesViewModel {
        return TopRatedMoviesViewModel(
            scope = IOScope(),
            data = TopRatedMovieViewData(),
            mapper = TopRatedMovieMapperImpl(),
            getTopRatedMoviesUseCase = getPopularMoviesUseCase
        )
    }
}