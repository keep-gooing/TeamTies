package com.example.teamties.feature.auth.data.repository
import com.example.teamties.core.model.Employee
import com.example.teamties.feature.auth.domain.repository.AuthRepository
import kotlinx.coroutines.delay
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.flow
import javax.inject.Inject
import javax.inject.Singleton
@Singleton
class FakeAuthRepositoryImpl @Inject constructor() : AuthRepository {
    private val _currentUser = MutableStateFlow<Employee?>(null)
    override fun login(email: String, password: String): Flow<Result<Employee>> = flow {
        delay(1000)
        if (email == "admin@teamties.com" && password == "admin123") {
            val user = Employee(
                id = "admin-1",
                name = "Admin User",
                position = "Administrator",
                email = email,
                phoneNumber = "+1 (555) 000-0000",
                department = "Operations",
                bio = "System administrator for TeamTies."
            )
            _currentUser.value = user
            emit(Result.success(user))
        } else if (email == "employee@teamties.com" && password == "password123") {
            val user = Employee(
                id = "emp-1",
                name = "John Doe",
                position = "Software Engineer",
                email = email,
                phoneNumber = "+1 (555) 000-1111",
                department = "Engineering",
                bio = "Full-stack developer."
            )
            _currentUser.value = user
            emit(Result.success(user))
        } else {
            emit(Result.failure(Exception("Invalid credentials")))
        }
    }
    override fun logout(): Flow<Result<Unit>> = flow {
        _currentUser.value = null
        emit(Result.success(Unit))
    }
    override fun getCurrentUser(): Flow<Employee?> = _currentUser
    override fun isAuthenticated(): Flow<Boolean> = flow {
        emit(_currentUser.value != null)
    }
}
