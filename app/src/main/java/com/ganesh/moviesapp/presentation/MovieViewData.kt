package com.ganesh.moviesapp.presentation

import androidx.lifecycle.MutableLiveData
import com.ganesh.moviesapp.core.BaseData

data class MovieViewData(
    val popularMovies: MutableLiveData<List<MovieItemViewData>> = MutableLiveData(mutableListOf()),
    val topRatedMovies: MutableLiveData<List<MovieItemViewData>> = MutableLiveData(mutableListOf()),
    val upcomingMovies: MutableLiveData<List<MovieItemViewData>> = MutableLiveData(mutableListOf())
): BaseData() {

}