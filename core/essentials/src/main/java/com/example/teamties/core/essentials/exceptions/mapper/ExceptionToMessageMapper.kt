package com.example.teamties.core.essentials.exceptions.mapper

interface ExceptionToMessageMapper {
    fun getLocalizedMessage(exception: Throwable): String
}
