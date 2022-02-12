package com.ganesh.moviesapp

import android.app.Application
import com.ganesh.moviesapp.di.DaggerAppComponent
import dagger.android.AndroidInjector
import dagger.android.DispatchingAndroidInjector
import dagger.android.HasAndroidInjector
import javax.inject.Inject

class App: Application(), HasAndroidInjector {
    @Inject
    lateinit var dispatchingAndroidInjector: DispatchingAndroidInjector<Any>

    //lateinit var appComponent: AppComponent

    override fun onCreate() {
        super.onCreate()
        DaggerAppComponent
            .builder()
            .application(this)
            .build()!!
            .inject(this)
    }

    override fun androidInjector(): AndroidInjector<Any> {
        return dispatchingAndroidInjector
        // appComponent = DaggerAppComponent.builder().application(this).build()
        //        return appComponent
    }

    companion object {
        const val BASE_URL: String = "https://api.themoviedb.org/3/"
    }
}