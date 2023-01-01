package com.ganesh.popularmovies.presentation

import androidx.lifecycle.MutableLiveData
import com.ganesh.core.BaseData

data class PopularMovieViewData(
    val popularMovies: MutableLiveData<List<PopularMovieItemViewData>> = MutableLiveData(mutableListOf()),
    val totalPages: MutableLiveData<Int> = MutableLiveData(1),
    val currentPage: MutableLiveData<Int> = MutableLiveData(1)
): BaseData()