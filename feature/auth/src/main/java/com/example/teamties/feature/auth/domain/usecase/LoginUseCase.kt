package com.example.teamties.feature.auth.domain.usecase
import com.example.teamties.core.essentials.error.General
import com.example.teamties.feature.auth.domain.error.AuthError
import com.example.teamties.core.essentials.error.Result
import com.example.teamties.core.model.Employee
import com.example.teamties.feature.auth.domain.repository.AuthRepository
import javax.inject.Inject

class LoginUseCase @Inject constructor(
    private val repository: AuthRepository
) {
    suspend operator fun invoke(email: String, password: String): Result<Employee, General> {
        if (email.isBlank()) {
            return Result.Error(AuthError.BlankEmail)
        }
        if (password.isBlank()) {
            return Result.Error(AuthError.BlankPassword)
        }
        return repository.login(email, password)
    }
}
