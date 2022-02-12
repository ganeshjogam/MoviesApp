package com.ganesh.moviesapp.di

import com.ganesh.moviesapp.presentation.IntroHomeFragment
import com.ganesh.moviesapp.presentation.OtpVerificationFragment
import dagger.Module
import dagger.android.ContributesAndroidInjector

@Module
abstract class IntroModule {

    @FragmentScoped
    @ContributesAndroidInjector
    abstract fun introHomeFragment(): IntroHomeFragment

    @FragmentScoped
    @ContributesAndroidInjector
    abstract fun otpVerificationFragment(): OtpVerificationFragment

}