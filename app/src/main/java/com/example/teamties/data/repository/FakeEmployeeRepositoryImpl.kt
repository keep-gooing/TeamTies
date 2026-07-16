package com.example.teamties.data.repository

import com.example.teamties.domain.model.Employee
import com.example.teamties.domain.repository.EmployeeRepository
import kotlinx.coroutines.delay
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.flowOf
import javax.inject.Inject
import javax.inject.Singleton

@Singleton
class FakeEmployeeRepositoryImpl @Inject constructor() : EmployeeRepository {

    private val employees = mutableListOf(
        Employee("1", "John Doe", "Developer", "john@example.com", "IT"),
        Employee("2", "Jane Smith", "Designer", "jane@example.com", "Creative")
    )

    private var currentToken: String? = null

    override fun getEmployees(): Flow<List<Employee>> {
        return flowOf(employees)
    }

    override suspend fun getEmployeeById(id: String): Employee? {
        return employees.find { it.id == id }
    }

    override suspend fun addEmployee(employee: Employee) {
        employees.add(employee)
    }

    override suspend fun deleteEmployee(id: String) {
        employees.removeIf { it.id == id }
    }

    override suspend fun login(email: String, password: String): Result<Employee> {
        delay(1500)

        val employee = employees.find { it.email == email }

        return if (employee != null && password == "123456") {
            val loggedInEmployee = employee.copy(token = "secure_token_for_${employee.id}")
            currentToken = loggedInEmployee.token
            Result.success(loggedInEmployee)
        } else {
            Result.failure(Exception("Невірний email або пароль"))
        }
    }

    override suspend fun logout() {
        currentToken = null
    }

    override suspend fun isUserLoggedIn(): Boolean {
        return currentToken != null
    }
}