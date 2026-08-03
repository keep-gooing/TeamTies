package com.example.teamties.feature.auth.presentation.resources
import com.example.teamties.core.essentials.resources.StringProvider
interface AuthStringProvider : StringProvider {
    val invalidCredentialsError: String
    val emailAlreadyExistsError: String
}
