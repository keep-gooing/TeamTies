package com.example.teamties.core.essentials.exceptions
import com.example.teamties.core.essentials.exceptions.base.AbstractCoreAppException
import com.example.teamties.core.essentials.resources.CoreStringProvider
class ConnectionException(
    cause: Throwable? = null,
) : AbstractCoreAppException("Network connection error", cause) {
    override fun getLocalizedErrorMessage(stringProvider: CoreStringProvider): String {
        return stringProvider.connectionErrorMessage
    }
}
