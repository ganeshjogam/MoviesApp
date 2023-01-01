package com.ganesh.moviesapp.di.presentation

import com.ganesh.core.IOScope
import com.ganesh.moviesapp.presentation.MainViewModel
import com.ganesh.moviesapp.presentation.MovieViewData
import dagger.Module
import dagger.Provides

@Module
class MainActivityPresentationModule {
    @Provides
    fun provideMainViewModel(): MainViewModel =
        MainViewModel(
            scope = IOScope(),
            data = MovieViewData()
        )
}