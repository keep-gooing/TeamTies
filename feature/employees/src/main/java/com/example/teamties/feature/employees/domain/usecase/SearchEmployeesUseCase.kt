package com.example.teamties.feature.employees.domain.usecase
import com.example.teamties.core.model.Employee
import com.example.teamties.feature.employees.domain.repository.EmployeeRepository
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.map
import javax.inject.Inject
class SearchEmployeesUseCase @Inject constructor(
    private val repository: EmployeeRepository
) {
    operator fun invoke(query: String): Flow<List<Employee>> {
        return repository.getEmployees().map { employees ->
            if (query.isBlank()) {
                employees
            } else {
                employees.filter { employee ->
                    employee.name.contains(query, ignoreCase = true) ||
                            employee.position.contains(query, ignoreCase = true) ||
                            employee.department.contains(query, ignoreCase = true)
                }
            }
        }
    }
}
