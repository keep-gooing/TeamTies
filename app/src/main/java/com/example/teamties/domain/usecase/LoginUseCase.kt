package com.example.teamties.domain.usecase

import com.example.teamties.domain.model.Employee
import com.example.teamties.domain.repository.EmployeeRepository
import javax.inject.Inject

class LoginUseCase @Inject constructor(
    private val repository: EmployeeRepository
) {
    suspend operator fun invoke(email: String, password: String): Result<Employee> {
        if (email.isBlank() || password.isBlank()) {
            return Result.failure(Exception("Email та пароль не можуть бути порожніми"))
        }
        return repository.login(email, password)
    }
}