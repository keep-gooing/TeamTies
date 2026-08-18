package com.example.teamties.feature.auth.domain.repository
import com.example.teamties.core.essentials.error.General
import com.example.teamties.core.essentials.error.Result
import com.example.teamties.core.model.Employee
import kotlinx.coroutines.flow.Flow

interface AuthRepository {
    suspend fun login(email: String, password: String): Result<Employee, General>
    suspend fun logout(): Result<Unit, General>
    fun getCurrentUser(): Flow<Employee?>
    fun isAuthenticated(): Flow<Boolean>
}
