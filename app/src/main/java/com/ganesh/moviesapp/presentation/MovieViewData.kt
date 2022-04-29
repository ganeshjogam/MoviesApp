package com.ganesh.moviesapp.presentation

import androidx.lifecycle.MutableLiveData
import com.ganesh.moviesapp.core.BaseData

data class MovieViewData(
    val popularMovies: MutableLiveData<List<MovieItemViewData>> = MutableLiveData(listOf()),
    val topRatedMovies: MutableLiveData<List<MovieItemViewData>> = MutableLiveData(listOf()),
    val upcomingMovies: MutableLiveData<List<MovieItemViewData>> = MutableLiveData(listOf())
): BaseData()