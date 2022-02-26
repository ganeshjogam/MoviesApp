package com.ganesh.moviesapp.core

sealed class BaseFailure {
    object NetworkConnection : BaseFailure()
}

//sealed class FeatureError: BaseFailure

class RemoteError(
    val type: RemoteErrorType = RemoteErrorType.Generic,
    val description: String? = null,
    val errorCode: Int? = null
) : BaseFailure()

enum class RemoteErrorType {
    Generic
}