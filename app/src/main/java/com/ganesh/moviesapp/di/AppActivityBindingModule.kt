package com.ganesh.moviesapp.di

import com.ganesh.moviesapp.di.data.MainActivityDataModule
import com.ganesh.moviesapp.di.data.TopRatedMoviesDataModule
import com.ganesh.moviesapp.di.data.UpcomingMoviesDataModule
import com.ganesh.moviesapp.di.domain.MainActivityDomainModule
import com.ganesh.moviesapp.di.domain.TopRatedMoviesDomainModule
import com.ganesh.moviesapp.di.domain.UpcomingMoviesDomainModule
import com.ganesh.moviesapp.di.presentation.MainActivityPresentationModule
import com.ganesh.moviesapp.di.presentation.TopRatedMoviesPresentationModule
import com.ganesh.moviesapp.di.presentation.UpcomingMoviesPresentationModule
import com.ganesh.moviesapp.presentation.MainActivity
import com.ganesh.moviesapp.presentation.toprated.TopRatedMoviesFragment
import com.ganesh.moviesapp.presentation.upcomingmovies.UpcomingMoviesFragment
import dagger.Module
import dagger.android.ContributesAndroidInjector

@Module
abstract class AppActivityBindingModule {
    @ActivityScoped
    @ContributesAndroidInjector(
        modules = [MainActivityPresentationModule::class,
            MainActivityDomainModule::class, MainActivityDataModule::class]
    )
    abstract fun providesMainActivity(): MainActivity

    @ContributesAndroidInjector(
        modules = [
            TopRatedMoviesPresentationModule::class,
            TopRatedMoviesDomainModule::class,
            TopRatedMoviesDataModule::class
        ]
    )
    abstract fun bindTopRatedMoviesFragment(): TopRatedMoviesFragment

    @ContributesAndroidInjector(
        modules = [
            UpcomingMoviesPresentationModule::class,
            UpcomingMoviesDomainModule::class,
            UpcomingMoviesDataModule::class
        ]
    )
    abstract fun bindUpcomingMoviesFragment(): UpcomingMoviesFragment

    /*@ActivityScoped
    @ContributesAndroidInjector(modules = [IntroModule::class])
    abstract fun providesIntroActivity(): IntroActivity*/
}