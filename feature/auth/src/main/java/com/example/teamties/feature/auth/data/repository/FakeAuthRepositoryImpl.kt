package com.example.teamties.feature.auth.data.repository
import com.example.teamties.core.model.Employee
import com.example.teamties.core.model.EmployeeRole
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

    override suspend fun login(email: String, password: String): Result<Employee> {
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
                role = EmployeeRole.ADMIN
            )
            _currentUser.value = user
            Result.success(user)
        } else if (email == "employee@teamties.com" && password == "password123") {
            val user = Employee(
                id = "emp-1",
                name = "John Doe",
                position = "Software Engineer",
                email = email,
                phoneNumber = "+1 (555) 000-1111",
                department = "Engineering",
                bio = "Full-stack developer.",
                role = EmployeeRole.EMPLOYEE
            )
            _currentUser.value = user
            Result.success(user)
        } else {
            Result.failure(Exception("Invalid credentials"))
        }
    }

    override suspend fun logout(): Result<Unit> {
        _currentUser.value = null
        return Result.success(Unit)
    }

    override fun getCurrentUser(): Flow<Employee?> = _currentUser
    override fun isAuthenticated(): Flow<Boolean> = _currentUser.map { it != null }
}
