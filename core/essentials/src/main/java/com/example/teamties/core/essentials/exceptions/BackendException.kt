package com.example.teamties.core.essentials.exceptions
import com.example.teamties.core.essentials.entities.HttpCode
import com.example.teamties.core.essentials.entities.ServerCode
import com.example.teamties.core.essentials.exceptions.base.AbstractCoreAppException
import com.example.teamties.core.essentials.resources.CoreStringProvider
class BackendException(
    val httpCode: HttpCode = HttpCode(400),
    val serverCode: ServerCode = ServerCode(""),
    val backendMessage: String = "",
    cause: Throwable? = null,
) : AbstractCoreAppException("Server error (serverCode=$serverCode, httpCode=$httpCode): $backendMessage", cause)
