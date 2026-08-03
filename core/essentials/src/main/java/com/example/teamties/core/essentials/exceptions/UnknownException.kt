package com.example.teamties.core.essentials.exceptions
import com.example.teamties.core.essentials.exceptions.base.AbstractAppException
class UnknownException(
    cause: Throwable
): AbstractAppException("Unknown exception", cause)
