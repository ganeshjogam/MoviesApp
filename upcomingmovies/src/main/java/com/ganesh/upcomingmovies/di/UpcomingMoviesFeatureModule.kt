package com.ganesh.upcomingmovies.di

import com.ganesh.upcomingmovies.di.data.UpcomingMoviesDataModule
import com.ganesh.upcomingmovies.di.domain.UpcomingMoviesDomainModule
import com.ganesh.upcomingmovies.di.presentation.UpcomingMoviesPresentationModule
import com.ganesh.upcomingmovies.presentation.UpcomingMoviesFragment
import dagger.Module
import dagger.android.ContributesAndroidInjector

@Module
abstract class UpcomingMoviesFeatureModule {
    @ContributesAndroidInjector(
        modules = [
            UpcomingMoviesPresentationModule::class,
            UpcomingMoviesDomainModule::class,
            UpcomingMoviesDataModule::class
        ]
    )
    abstract fun bindPopularMoviesFragment(): UpcomingMoviesFragment
}