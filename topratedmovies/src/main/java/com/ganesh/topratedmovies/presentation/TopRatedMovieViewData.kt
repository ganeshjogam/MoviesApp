package com.ganesh.topratedmovies.presentation

import androidx.lifecycle.MutableLiveData
import com.ganesh.core.BaseData

data class TopRatedMovieViewData(
    val topRatedMovies: MutableLiveData<List<TopRatedMovieItemViewData>> = MutableLiveData(mutableListOf()),
    val totalPages: MutableLiveData<Int> = MutableLiveData(1),
    val currentPage: MutableLiveData<Int> = MutableLiveData(1)
): BaseData()