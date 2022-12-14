package com.ganesh.moviesapp.di.presentation

import com.ganesh.core.IOScope
import com.ganesh.moviesapp.domain.usecase.GetTopRatedMoviesUseCase
import com.ganesh.moviesapp.presentation.mapper.MovieMapperImpl
import com.ganesh.moviesapp.presentation.toprated.TopRatedMovieViewData
import com.ganesh.moviesapp.presentation.toprated.TopRatedMoviesViewModel
import dagger.Module
import dagger.Provides

@Module
class TopRatedMoviesPresentationModule {
    @Provides
    fun provideTopRatedMovieViewModel(
        getTopRatedMoviesUseCase: GetTopRatedMoviesUseCase
    ): TopRatedMoviesViewModel {
        return TopRatedMoviesViewModel(
            scope = IOScope(),
            data = TopRatedMovieViewData(),
            getTopRatedMoviesUseCase = getTopRatedMoviesUseCase,
            mapper = MovieMapperImpl()
        )
    }
}