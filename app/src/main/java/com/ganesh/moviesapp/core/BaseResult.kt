package com.ganesh.moviesapp.core

sealed class BaseResult<out E, out S> {
    data class Success<out S>(val success: S) : BaseResult<Nothing, S>()
    data class Error<out E>(val error: E) : BaseResult<E, Nothing>()

    val isSuccess get() = this is Success<S>
    val isError get() = this is Error<E>

    fun <R> success(right: R): Success<R> = Success(right)

    fun <L> error(left: L): Error<L> = Error(left)

    fun fold(
        fnL: (E) -> Any,
        fnR: (S) -> Any
    ): Any = when (this) {
        is Error -> fnL(error)
        is Success -> fnR(success)
    }

    
}