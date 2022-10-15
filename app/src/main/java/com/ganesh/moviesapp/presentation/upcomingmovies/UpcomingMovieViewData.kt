package com.ganesh.moviesapp.presentation.upcomingmovies

import androidx.lifecycle.MutableLiveData
import com.ganesh.moviesapp.core.BaseData
import com.ganesh.moviesapp.presentation.MovieItemViewData

data class UpcomingMovieViewData(
    val upcomingMovies: MutableLiveData<List<MovieItemViewData>> = MutableLiveData(mutableListOf())
): BaseData()