package com.example.teamties.core.essentials.exceptions

import com.example.teamties.core.essentials.exceptions.base.AbstractCoreAppException
import com.example.teamties.core.essentials.resources.CoreStringProvider


class InvalidBackendResponseException(
    cause: Throwable? = null,
) : AbstractCoreAppException("Can't parse server response", cause) {

    override fun getLocalizedErrorMessage(stringProvider: CoreStringProvider): String {
        return stringProvider.invalidBackendResponseErrorMessage
    }
}
