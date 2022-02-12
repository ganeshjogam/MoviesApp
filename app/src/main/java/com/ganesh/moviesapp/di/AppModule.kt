package com.ganesh.moviesapp.di

import android.app.Application
import android.content.Context
import com.ganesh.moviesapp.Api
import com.ganesh.moviesapp.App
import dagger.Binds
import dagger.Module
import dagger.Provides
import okhttp3.OkHttpClient
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import javax.inject.Singleton

@Module
abstract class AppModule() {
    @Binds
    abstract fun bindContext(application: Application): Context
}