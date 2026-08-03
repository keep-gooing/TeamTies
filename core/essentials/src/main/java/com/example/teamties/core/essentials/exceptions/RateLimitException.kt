package com.example.teamties.core.essentials.exceptions
import com.example.teamties.core.essentials.exceptions.base.AbstractCoreAppException
import com.example.teamties.core.essentials.resources.CoreStringProvider
class RateLimitException(
    cause: Throwable? = null
) : AbstractCoreAppException(
    message = "Too many requests.",
    cause = cause,
) {
    override fun getLocalizedErrorMessage(stringProvider: CoreStringProvider): String {
        return stringProvider.tooManyRequests
    }
}
