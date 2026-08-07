package com.example.teamties.feature.employees.domain.repository
import com.example.teamties.core.model.Employee
import kotlinx.coroutines.flow.Flow
interface EmployeeRepository {
    fun getEmployees(): Flow<List<Employee>>
    fun searchEmployees(query: String): Flow<List<Employee>>
    suspend fun getEmployeeById(id: String): Employee?
    suspend fun addEmployee(employee: Employee)
    suspend fun deleteEmployee(id: String)
}
