package com.example.teamties.feature.auth.domain.repository
import com.example.teamties.core.model.Employee
import kotlinx.coroutines.flow.Flow
interface AuthRepository {
    suspend fun login(email: String, password: String): Result<Employee>
    suspend fun logout(): Result<Unit>
    fun getCurrentUser(): Flow<Employee?>
    fun isAuthenticated(): Flow<Boolean>
}
