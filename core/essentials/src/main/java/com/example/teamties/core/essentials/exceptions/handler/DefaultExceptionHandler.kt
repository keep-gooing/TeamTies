package com.example.teamties.core.essentials.exceptions.handler
import javax.inject.Inject
class DefaultExceptionHandler @Inject constructor() : ExceptionHandler {
    override fun handleException(exception: Throwable) {
        exception.printStackTrace()
    }
}
