package com.example.teamties.core.essentials.error

sealed interface Result<out D, out E : General> {
    data class Success<out D>(val data: D) : Result<D, Nothing>
    data class Error<out E : General>(val error: E) : Result<Nothing, E>
}

inline fun <D, E : General, R> Result<D, E>.map(transform: (D) -> R): Result<R, E> {
    return when (this) {
        is Result.Success -> Result.Success(transform(data))
        is Result.Error -> Result.Error(error)
    }
}

fun <D, E : General> Result<D, E>.asEmptyDataResult(): Result<Unit, E> {
    return map { }
}

inline fun <D, E : General> Result<D, E>.onSuccess(action: (D) -> Unit): Result<D, E> {
    if (this is Result.Success) action(data)
    return this
}

inline fun <D, E : General> Result<D, E>.onError(action: (E) -> Unit): Result<D, E> {
    if (this is Result.Error) action(error)
    return this
}
