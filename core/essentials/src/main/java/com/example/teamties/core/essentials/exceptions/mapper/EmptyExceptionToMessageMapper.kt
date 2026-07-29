package com.example.teamties.core.essentials.exceptions.mapper


class EmptyExceptionToMessageMapper : ExceptionToMessageMapper {

    override fun getLocalizedMessage(exception: Exception): String {
        return exception.message ?: "Unknown error occurred"
    }
}
