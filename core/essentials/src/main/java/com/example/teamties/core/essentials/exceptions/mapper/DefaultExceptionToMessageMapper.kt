package com.example.teamties.core.essentials.exceptions.mapper
import com.example.teamties.core.essentials.exceptions.*
import com.example.teamties.core.essentials.exceptions.base.WithLocalizedMessage
import com.example.teamties.core.essentials.resources.CoreStringProvider
import com.example.teamties.core.essentials.resources.StringProviderStore
import javax.inject.Inject

class DefaultExceptionToMessageMapper @Inject constructor(
    private val stringProviderStore: StringProviderStore,
) : ExceptionToMessageMapper {
    override fun getLocalizedMessage(exception: Throwable): String {
        val coreStringProvider = stringProviderStore<CoreStringProvider>()
        return when (exception) {
            is BackendException -> coreStringProvider.backendErrorMessage(
                exception.serverCode,
                exception.httpCode,
                exception.backendMessage
            )
            is ConnectionException -> coreStringProvider.connectionError
            is InvalidBackendResponseException -> coreStringProvider.invalidBackendResponseError
            is RateLimitException -> coreStringProvider.tooManyRequests
            is WithLocalizedMessage -> exception.getLocalizedErrorMessage(stringProviderStore)
            else -> exception.message ?: coreStringProvider.unknownError
        }
    }
}
