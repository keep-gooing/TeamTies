package com.example.teamties.core.essentials.exceptions.mapper
import com.example.teamties.core.essentials.exceptions.base.WithLocalizedMessage
import com.example.teamties.core.essentials.resources.CoreStringProvider
import com.example.teamties.core.essentials.resources.StringProviderStore
import javax.inject.Inject
class DefaultExceptionToMessageMapper @Inject constructor(
    private val stringProviderStore: StringProviderStore,
) : ExceptionToMessageMapper {
    override fun getLocalizedMessage(exception: Throwable): String {
        return when (exception) {
            is WithLocalizedMessage -> exception.getLocalizedErrorMessage(stringProviderStore)
            else -> exception.message ?: stringProviderStore<CoreStringProvider>().unknownErrorMessage
        }
    }
}
