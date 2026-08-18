package com.example.teamties.core.essentials.resources
import com.example.teamties.core.essentials.entities.HttpCode
import com.example.teamties.core.essentials.entities.ServerCode
interface CoreStringProvider : StringProvider {
    val connectionError: String
    val serverError: String
    val unknownError: String
    val invalidBackendResponseError: String
    val tooManyRequests: String
    val deleteAction: String
    val cancelAction: String
    fun backendErrorMessage(
        serverCode: ServerCode,
        httpCode: HttpCode,
        backendMessage: String,
    ): String
}
