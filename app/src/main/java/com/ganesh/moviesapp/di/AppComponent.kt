package com.ganesh.moviesapp.di

import android.app.Application
import com.ganesh.moviesapp.App
import com.ganesh.moviesapp.di.presentation.BuildersModule
import dagger.BindsInstance
import dagger.Component
import dagger.android.AndroidInjectionModule


@Component(
    modules = [
        AndroidInjectionModule::class,
        AppModule::class,
        BuildersModule::class
    ]
)
interface AppComponent {
    @Component.Builder
    interface Builder {
        @BindsInstance
        fun application(application: Application): Builder
        fun build(): AppComponent?
    }

    fun inject(app: App)
}