package com.example.teamties.core.essentials.exceptions.mapper
class EmptyExceptionToMessageMapper : ExceptionToMessageMapper {
    override fun getLocalizedMessage(exception: Throwable): String {
        return exception.message ?: "Unknown error occurred"
    }
}
