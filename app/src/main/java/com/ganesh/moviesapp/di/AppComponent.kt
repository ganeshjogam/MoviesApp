package com.ganesh.moviesapp.di

import android.app.Application
import com.ganesh.moviesapp.App
import com.ganesh.popularmovies.di.PopularMoviesFeatureModule
import dagger.BindsInstance
import dagger.Component
import dagger.android.AndroidInjectionModule
import javax.inject.Singleton

@Singleton
@Component(
    modules = [
        AndroidInjectionModule::class,
        AppModule::class,
        AppActivityBindingModule::class,
        NetworkModule::class,
        PopularMoviesFeatureModule::class
    ]
)
interface AppComponent {
    @Component.Builder
    interface Builder {
        @BindsInstance
        fun application(application: Application): Builder
        fun build(): AppComponent
    }

    fun inject(app: App)
}