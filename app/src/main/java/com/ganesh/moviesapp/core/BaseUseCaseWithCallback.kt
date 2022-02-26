package com.ganesh.moviesapp.core

interface BaseUseCaseWithCallback<in Params> {
    operator fun invoke(params: Params): Unit
}