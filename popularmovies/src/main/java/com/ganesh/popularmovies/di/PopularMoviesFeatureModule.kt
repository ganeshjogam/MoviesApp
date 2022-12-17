package com.ganesh.popularmovies.di

import com.ganesh.popularmovies.di.data.PopularMoviesDataModule
import com.ganesh.popularmovies.di.domain.PopularMoviesDomainModule
import com.ganesh.popularmovies.di.presentation.PopularMoviesPresentationModule
import com.ganesh.popularmovies.presentation.PopularMoviesFragment
import dagger.Module
import dagger.android.ContributesAndroidInjector

@Module
abstract class PopularMoviesFeatureModule {
    @ContributesAndroidInjector(
        modules = [
            PopularMoviesPresentationModule::class,
            PopularMoviesDomainModule::class,
            PopularMoviesDataModule::class
        ]
    )
    abstract fun bindPopularMoviesFragment(): PopularMoviesFragment
}