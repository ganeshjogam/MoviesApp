package com.ganesh.moviesapp.presentation.upcomingmovies

import androidx.lifecycle.MutableLiveData
import com.ganesh.moviesapp.core.BaseData
import com.ganesh.moviesapp.presentation.MovieItemViewData

data class UpcomingMovieViewData(
    val upcomingMovies: MutableLiveData<List<MovieItemViewData>> = MutableLiveData(mutableListOf()),
    val totalPages: MutableLiveData<Int> = MutableLiveData(1),
    val currentPage: MutableLiveData<Int> = MutableLiveData(1)
): BaseData()