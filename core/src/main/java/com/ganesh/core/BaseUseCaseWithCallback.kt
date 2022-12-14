package com.ganesh.core

interface BaseUseCaseWithCallback<in Params> {
    operator fun invoke(params: Params): Unit
}