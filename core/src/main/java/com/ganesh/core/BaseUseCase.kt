package com.ganesh.core

import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.withContext
import kotlin.coroutines.CoroutineContext

interface BaseUseCase<in Params, out Type> where Type : Any {
    suspend operator fun invoke(
        params: Params,
        context: CoroutineContext = Dispatchers.IO
    ): BaseResult<BaseFailure, Type> = withContext(context) {
        invoke(params)
    }

    object NONE
}

