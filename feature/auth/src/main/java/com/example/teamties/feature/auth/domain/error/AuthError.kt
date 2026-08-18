package com.example.teamties.feature.auth.domain.error

import com.example.teamties.core.essentials.error.General
import com.example.teamties.core.essentials.error.GeneralError

sealed interface AuthError : General {
    data object InvalidEmail : AuthError
    data object BlankEmail : AuthError
    data object BlankPassword : AuthError
    data object PasswordTooShort : AuthError
    data object InvalidCredentials : AuthError
    data object UserNotFound : AuthError
    data class Basic(val error: GeneralError) : AuthError
}
