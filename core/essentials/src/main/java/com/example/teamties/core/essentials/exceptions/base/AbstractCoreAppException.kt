package com.example.teamties.core.essentials.exceptions.base
import com.example.teamties.core.essentials.resources.CoreStringProvider
import com.example.teamties.core.essentials.resources.StringProviderStore
abstract class AbstractCoreAppException(
    message: String,
    cause: Throwable? = null,
) : AbstractAppException(message, cause), WithLocalizedMessage {
    override fun getLocalizedErrorMessage(stringProviderStore: StringProviderStore): String {
        return "General error"
    }
}
