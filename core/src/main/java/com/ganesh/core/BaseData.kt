package com.ganesh.core

import androidx.lifecycle.MutableLiveData

abstract class BaseData(
    var showLoading: MutableLiveData<Boolean> = MutableLiveData(false),
    var showError: MutableLiveData<Boolean> = MutableLiveData(false)
) {
    fun loading() {
        showLoading.value = true
        showError.value = false
    }

    fun error() {
        showLoading.value = false
        showError.value = true
    }
}