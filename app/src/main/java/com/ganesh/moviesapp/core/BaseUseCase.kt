package com.ganesh.moviesapp.core

interface BaseUseCase<in Params, out Type> where Type : Any {
    operator fun invoke(params: Params): BaseResult<BaseFailure, Type> = invoke(params)

    object NONE
}

