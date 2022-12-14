package com.ganesh.moviesapp.presentation.popularmovies

import androidx.lifecycle.MutableLiveData
import com.ganesh.core.BaseData
import com.ganesh.moviesapp.presentation.MovieItemViewData

data class PopularMovieViewData(
    val popularMovies: MutableLiveData<List<MovieItemViewData>> = MutableLiveData(mutableListOf()),
    val totalPages: MutableLiveData<Int> = MutableLiveData(1),
    val currentPage: MutableLiveData<Int> = MutableLiveData(1)
): BaseData()