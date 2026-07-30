package com.example.teamties.feature.auth.domain.usecase

import com.example.teamties.core.model.Employee
import com.example.teamties.feature.auth.domain.repository.AuthRepository
import kotlinx.coroutines.flow.Flow
import javax.inject.Inject

class LoginUseCase @Inject constructor(
    private val repository: AuthRepository
) {
    operator fun invoke(email: String, password: String): Flow<Result<Employee>> {
        return repository.login(email, password)
    }
}
