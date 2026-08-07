package com.example.teamties.core.essentials.exceptions
import com.example.teamties.core.essentials.exceptions.base.AbstractCoreAppException

class ConnectionException(
    cause: Throwable? = null,
) : AbstractCoreAppException("Network connection error", cause)
