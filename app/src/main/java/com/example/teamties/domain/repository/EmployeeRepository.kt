package com.example.teamties.domain.repository

import com.example.teamties.domain.model.Employee
import kotlinx.coroutines.flow.Flow

interface EmployeeRepository {

    fun getEmployees(): Flow<List<Employee>>
    suspend fun getEmployeeById(id: String): Employee?
    suspend fun addEmployee(employee: Employee)
    suspend fun deleteEmployee(id: String)

    suspend fun login(email: String, password: String): Result<Employee>
    suspend fun logout()
    suspend fun isUserLoggedIn(): Boolean
}