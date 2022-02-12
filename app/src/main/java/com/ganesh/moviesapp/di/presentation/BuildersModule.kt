package com.ganesh.moviesapp.di.presentation

import com.ganesh.moviesapp.presentation.MainActivity
import com.ganesh.moviesapp.presentation.MainFragment
import dagger.Module
import dagger.android.ContributesAndroidInjector

/**
 * Binds all sub-components within the app.
 * https://proandroiddev.com/exploring-the-new-dagger-android-module-9eb6075f1a46
 * https://proandroiddev.com/mvvm-architecture-viewmodel-and-livedata-part-2-di-1a6b1f96d84b
 */
@Module
abstract class BuildersModule {
    @ContributesAndroidInjector(modules = [MainActivityModule::class])
    abstract fun bindMainActivity(): MainActivity

    @ContributesAndroidInjector(modules = [MainFragmentModule::class])
    abstract fun bindMainFragment(): MainFragment

    // Add bindings for other sub-components here


    //Note that the Fragment injection is done in onAttach(Context context) via AndroidSupportInjection.inject(this) before the call to super
    /*
    @ContributesAndroidInjector(modules = LobbyFragmentModule.class)
    // or gain access to lobby activity dependencies from fragment via
    // @ContributesAndroidInjector(modules = {LobbyFragmentModule.class, LobbyActivityModule.class})
    abstract LobbyFragment bindLobbyFragment();
    * */
}