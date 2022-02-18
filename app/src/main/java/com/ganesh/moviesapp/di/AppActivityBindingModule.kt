package com.ganesh.moviesapp.di

import com.ganesh.moviesapp.di.presentation.MainActivityModule
import com.ganesh.moviesapp.presentation.IntroActivity
import com.ganesh.moviesapp.presentation.MainActivity
import dagger.Module
import dagger.android.ContributesAndroidInjector

@Module
abstract class AppActivityBindingModule {
    @ActivityScoped
    @ContributesAndroidInjector(modules = [MainActivityModule::class])
    abstract fun providesMainActivity(): MainActivity

    /*@ActivityScoped
    @ContributesAndroidInjector(modules = [IntroModule::class])
    abstract fun providesIntroActivity(): IntroActivity*/
}