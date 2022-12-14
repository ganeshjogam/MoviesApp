package com.ganesh.core

suspend fun <E, M> request(
    call: suspend () -> E,
    handleSuccess: (E, Int) -> M,
    handleError: (Int) -> BaseFailure = { _-> RemoteError() }
): BaseResult<BaseFailure, M> =
    try {
        val response = call()
        val responseBody = response
        BaseResult.Success(handleSuccess(responseBody, 200))
    } catch (exception: Exception) {
        exception.printStackTrace()
        BaseResult.Error(RemoteError())
    }