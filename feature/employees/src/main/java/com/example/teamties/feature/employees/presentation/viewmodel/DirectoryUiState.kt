package com.example.teamties.feature.employees.presentation.viewmodel
import com.example.teamties.core.model.Employee
sealed interface DirectoryUiState {
    object Loading : DirectoryUiState
    data class Success(val employees: List<Employee>) : DirectoryUiState
    data class Error(val message: String) : DirectoryUiState
    object Empty : DirectoryUiState
}
