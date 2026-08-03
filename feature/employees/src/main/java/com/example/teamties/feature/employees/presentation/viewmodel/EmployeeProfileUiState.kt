package com.example.teamties.feature.employees.presentation.viewmodel
import com.example.teamties.core.model.Employee
sealed interface EmployeeProfileUiState {
    object Loading : EmployeeProfileUiState
    data class Success(val employee: Employee) : EmployeeProfileUiState
    data class Error(val message: String) : EmployeeProfileUiState
}
