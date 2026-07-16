package com.example.teamties.domain.usecase

import com.example.teamties.domain.model.Employee
import com.example.teamties.domain.repository.EmployeeRepository
import kotlinx.coroutines.flow.Flow
import javax.inject.Inject

class GetEmployeesUseCase @Inject constructor(
    private val repository: EmployeeRepository
) {
    operator fun invoke(): Flow<List<Employee>> {
        return repository.getEmployees()
    }
}
