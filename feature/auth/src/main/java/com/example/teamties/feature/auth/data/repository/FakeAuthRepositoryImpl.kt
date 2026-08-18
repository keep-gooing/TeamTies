package com.example.teamties.feature.auth.data.repository
import com.example.teamties.core.essentials.error.General
import com.example.teamties.feature.auth.domain.error.AuthError
import com.example.teamties.core.essentials.error.Result
import com.example.teamties.core.model.AppPermission
import com.example.teamties.core.model.Employee
import com.example.teamties.feature.auth.domain.repository.AuthRepository
import kotlinx.coroutines.delay
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.map
import javax.inject.Inject
import javax.inject.Singleton

@Singleton
class FakeAuthRepositoryImpl @Inject constructor() : AuthRepository {
    private val _currentUser = MutableStateFlow<Employee?>(null)

    override suspend fun login(email: String, password: String): Result<Employee, General> {
        delay(1000)
        return if (email == "admin@teamties.com" && password == "admin123") {
            val user = Employee(
                id = "admin-1",
                name = "Admin User",
                position = "Administrator",
                email = email,
                phoneNumber = "+1 (555) 000-0000",
                department = "Operations",
                bio = "System administrator for TeamTies.",
                permissions = AppPermission.entries.toSet()
            )
            _currentUser.value = user
            Result.Success(user)
        } else if (email == "employee@teamties.com" && password == "password123") {
            val user = Employee(
                id = "emp-1",
                name = "John Doe",
                position = "Software Engineer",
                email = email,
                phoneNumber = "+1 (555) 000-1111",
                department = "Engineering",
                bio = "Full-stack developer.",
                permissions = emptySet()
            )
            _currentUser.value = user
            Result.Success(user)
        } else {
            Result.Error(AuthError.InvalidCredentials)
        }
    }

    override suspend fun logout(): Result<Unit, General> {
        _currentUser.value = null
        return Result.Success(Unit)
    }

    override fun getCurrentUser(): Flow<Employee?> = _currentUser
    override fun isAuthenticated(): Flow<Boolean> = _currentUser.map { it != null }
}
