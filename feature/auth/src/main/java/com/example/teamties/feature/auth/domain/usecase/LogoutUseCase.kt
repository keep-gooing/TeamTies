package com.example.teamties.feature.auth.domain.usecase
import com.example.teamties.core.essentials.error.General
import com.example.teamties.core.essentials.error.Result
import com.example.teamties.feature.auth.domain.repository.AuthRepository
import javax.inject.Inject

class LogoutUseCase @Inject constructor(
    private val repository: AuthRepository
) {
    suspend operator fun invoke(): Result<Unit, General> {
        return repository.logout()
    }
}
