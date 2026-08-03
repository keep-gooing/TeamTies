package com.example.teamties.feature.auth.presentation.exceptions
import com.example.teamties.core.essentials.exceptions.base.AbstractAppException
import com.example.teamties.core.essentials.exceptions.base.WithLocalizedMessage
import com.example.teamties.core.essentials.resources.StringProviderStore
import com.example.teamties.feature.auth.presentation.resources.AuthStringProvider
abstract class AbstractAuthException(
    message: String,
    cause: Throwable? = null,
) : AbstractAppException(message, cause), WithLocalizedMessage {
    override fun getLocalizedErrorMessage(stringProviderStore: StringProviderStore): String {
        return getLocalizedErrorMessage(stringProviderStore<AuthStringProvider>())
    }
    abstract fun getLocalizedErrorMessage(stringProvider: AuthStringProvider): String
}
