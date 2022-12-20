package com.ganesh.upcomingmovies.presentation

import androidx.lifecycle.MutableLiveData
import com.ganesh.core.BaseData

data class UpcomingMovieViewData(
    val upcomingMovies: MutableLiveData<List<UpcomingMovieItemViewData>> = MutableLiveData(mutableListOf()),
    val totalPages: MutableLiveData<Int> = MutableLiveData(1),
    val currentPage: MutableLiveData<Int> = MutableLiveData(1)
): BaseData()