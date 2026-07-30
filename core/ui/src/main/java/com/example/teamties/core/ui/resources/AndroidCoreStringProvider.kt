package com.example.teamties.core.ui.resources

import android.content.Context
import com.example.teamties.core.essentials.entities.HttpCode
import com.example.teamties.core.essentials.entities.ServerCode
import com.example.teamties.core.essentials.resources.CoreStringProvider
import com.example.teamties.core.ui.R
import dagger.hilt.android.qualifiers.ApplicationContext
import javax.inject.Inject
import javax.inject.Singleton

@Singleton
class AndroidCoreStringProvider @Inject constructor(
    @ApplicationContext private val context: Context
) : CoreStringProvider {
    override val connectionErrorMessage: String
        get() = context.getString(R.string.error_connection)
    override val unknownErrorMessage: String
        get() = context.getString(R.string.error_unknown)
    override val invalidBackendResponseErrorMessage: String
        get() = context.getString(R.string.error_invalid_backend_response)
    override val tooManyRequests: String
        get() = context.getString(R.string.error_rate_limit)
    override val deleteAction: String
        get() = context.getString(R.string.action_delete)
    override val cancelAction: String
        get() = context.getString(R.string.action_cancel)

    override fun backendErrorMessage(
        serverCode: ServerCode,
        httpCode: HttpCode,
        backendMessage: String
    ): String {
        return context.getString(R.string.error_backend, serverCode.value, backendMessage)
    }
}
