package com.example.teamties.feature.auth.presentation.mapper

import com.example.teamties.core.essentials.error.General
import com.example.teamties.core.essentials.error.GeneralError
import com.example.teamties.core.essentials.resources.CoreStringProvider
import com.example.teamties.core.essentials.resources.StringProviderStore
import com.example.teamties.feature.auth.domain.error.AuthError
import com.example.teamties.feature.auth.presentation.resources.AuthStringProvider
import javax.inject.Inject

class AuthErrorMapper @Inject constructor(
    private val stringProviderStore: StringProviderStore
) {
    fun map(error: General): String {
        val coreStrings = stringProviderStore<CoreStringProvider>()
        val authStrings = stringProviderStore<AuthStringProvider>()

        return when (error) {
            AuthError.BlankEmail -> "Email cannot be blank"
            AuthError.BlankPassword -> "Password cannot be blank"
            AuthError.InvalidEmail -> "Invalid email format"
            AuthError.PasswordTooShort -> "Password is too short"
            AuthError.InvalidCredentials -> authStrings.invalidCredentialsError
            AuthError.UserNotFound -> "User not found"
            is AuthError.Basic -> mapGeneralError(error.error, coreStrings)
            is GeneralError -> mapGeneralError(error, coreStrings)
            else -> coreStrings.unknownError
        }
    }

    private fun mapGeneralError(error: GeneralError, coreStrings: CoreStringProvider): String {
        return when (error) {
            GeneralError.Network -> coreStrings.connectionError
            GeneralError.Server -> coreStrings.serverError
            GeneralError.Unknown -> coreStrings.unknownError
        }
    }
}
