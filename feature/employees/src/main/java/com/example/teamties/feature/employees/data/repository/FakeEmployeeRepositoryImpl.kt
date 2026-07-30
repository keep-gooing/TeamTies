package com.example.teamties.feature.employees.data.repository

import com.example.teamties.core.model.Employee
import com.example.teamties.feature.employees.domain.repository.EmployeeRepository
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
}
