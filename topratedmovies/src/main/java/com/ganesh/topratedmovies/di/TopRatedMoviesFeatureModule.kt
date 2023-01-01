package com.ganesh.topratedmovies.di

import com.ganesh.topratedmovies.di.data.TopRatedMoviesDataModule
import com.ganesh.topratedmovies.di.domain.TopRatedMoviesDomainModule
import com.ganesh.topratedmovies.di.presentation.TopRatedMoviesPresentationModule
import com.ganesh.topratedmovies.presentation.TopRatedMoviesFragment
import dagger.Module
import dagger.android.ContributesAndroidInjector

@Module
abstract class TopRatedMoviesFeatureModule {
    @ContributesAndroidInjector(
        modules = [
            TopRatedMoviesPresentationModule::class,
            TopRatedMoviesDomainModule::class,
            TopRatedMoviesDataModule::class
        ]
    )
    abstract fun bindPopularMoviesFragment(): TopRatedMoviesFragment
}