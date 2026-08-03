package com.example.teamties.feature.employees.domain.usecase
import com.example.teamties.core.model.Employee
import com.example.teamties.feature.employees.domain.repository.EmployeeRepository
import javax.inject.Inject
class GetEmployeeByIdUseCase @Inject constructor(
    private val repository: EmployeeRepository
) {
    suspend operator fun invoke(id: String): Employee? {
        return repository.getEmployeeById(id)
    }
}
