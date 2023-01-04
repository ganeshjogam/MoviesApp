package com.ganesh.moviesapp.presentation

import android.content.Context
import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import com.ganesh.moviesapp.*
import com.ganesh.popularmovies.presentation.PopularMoviesFragment
import com.ganesh.topratedmovies.presentation.TopRatedMoviesFragment
import com.ganesh.upcomingmovies.presentation.UpcomingMoviesFragment
import com.google.android.material.bottomnavigation.BottomNavigationView
import com.google.android.material.navigation.NavigationBarView
import dagger.android.AndroidInjection
import dagger.android.AndroidInjector
import dagger.android.DispatchingAndroidInjector
import dagger.android.HasAndroidInjector
import javax.inject.Inject

// https://www.arthlimchiu.com/2019/10/02/make-a-movies-app-part-1.html
/*
we need to update the LobbyActivity to support injecting fragments by implementing
HasSupportFragmentInjector. Note, if our activity did not contain any fragments or
the fragments did not need to inject anything, the activity would not need to implement HasSupportFragmentInjector.

* */
//https://medium.com/androidxx/an-approach-to-a-multi-module-app-with-navigation-component-and-fragment-result-api-378b6716da2e
//https://medium.com/simform-engineering/getting-started-with-jenkins-android-1138ee3d1e99
class MainActivity : AppCompatActivity(), HasAndroidInjector {
    @Inject
    lateinit var dispatchingAndroidInjector: DispatchingAndroidInjector<Any>

    @Inject
    lateinit var injectedContext: Context

    @Inject
    lateinit var mainViewModel: MainViewModel

    override fun onCreate(savedInstanceState: Bundle?) {
        AndroidInjection.inject(this)
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        print("Rahul $injectedContext")

        val bottomNav = findViewById<BottomNavigationView>(R.id.bottom_navigation)
        bottomNav.setOnItemSelectedListener(NavigationBarView.OnItemSelectedListener {
            val fragmnet = when (it.itemId) {
                R.id.action_popular_movies -> PopularMoviesFragment.newInstance()
                R.id.action_top_rated_movies -> TopRatedMoviesFragment.newInstance()
                R.id.action_upcoming_movies -> UpcomingMoviesFragment.newInstance()
                else -> null

            }

            fragmnet?.let {
                supportFragmentManager
                    .beginTransaction()
                    .replace(R.id.fragment_container, it)
                    .commit()
            }
            return@OnItemSelectedListener true
        })

        supportFragmentManager
            .beginTransaction()
            .replace(R.id.fragment_container, PopularMoviesFragment.newInstance())
            .commit()

        mainViewModel.init()

    }

    override fun androidInjector(): AndroidInjector<Any> {
        return dispatchingAndroidInjector
    }

}