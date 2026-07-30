package com.example.teamties.feature.auth.domain.repository

import com.example.teamties.core.model.Employee
import kotlinx.coroutines.flow.Flow

interface AuthRepository {
    fun login(email: String, password: String): Flow<Result<Employee>>
    fun logout(): Flow<Result<Unit>>
    fun getCurrentUser(): Flow<Employee?>
    fun isAuthenticated(): Flow<Boolean>
}
