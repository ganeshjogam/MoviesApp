package com.ganesh.moviesapp.di

import com.ganesh.moviesapp.di.data.MainActivityDataModule
import com.ganesh.moviesapp.di.domain.MainActivityDomainModule
import com.ganesh.moviesapp.di.presentation.MainActivityPresentationModule
import com.ganesh.moviesapp.presentation.MainActivity
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

    /*@ActivityScoped
    @ContributesAndroidInjector(modules = [IntroModule::class])
    abstract fun providesIntroActivity(): IntroActivity*/
}