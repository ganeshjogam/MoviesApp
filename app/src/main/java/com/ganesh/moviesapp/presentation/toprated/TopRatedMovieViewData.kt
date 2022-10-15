package com.ganesh.moviesapp.presentation.toprated

import androidx.lifecycle.MutableLiveData
import com.ganesh.moviesapp.core.BaseData
import com.ganesh.moviesapp.presentation.MovieItemViewData

data class TopRatedMovieViewData(
    val topRatedMovies: MutableLiveData<List<MovieItemViewData>> = MutableLiveData(mutableListOf())
): BaseData()