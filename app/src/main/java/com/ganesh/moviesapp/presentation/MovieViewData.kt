package com.ganesh.moviesapp.presentation

import androidx.lifecycle.MutableLiveData
import com.ganesh.moviesapp.core.BaseData

data class MovieViewData(
    val status: MutableLiveData<Boolean> = MutableLiveData()
) : BaseData()