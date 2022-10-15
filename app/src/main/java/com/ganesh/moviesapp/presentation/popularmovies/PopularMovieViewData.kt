package com.ganesh.moviesapp.presentation.popularmovies

import androidx.lifecycle.MutableLiveData
import com.ganesh.moviesapp.core.BaseData
import com.ganesh.moviesapp.presentation.MovieItemViewData

data class PopularMovieViewData(
    val popularMovies: MutableLiveData<List<MovieItemViewData>> = MutableLiveData(mutableListOf())
): BaseData()