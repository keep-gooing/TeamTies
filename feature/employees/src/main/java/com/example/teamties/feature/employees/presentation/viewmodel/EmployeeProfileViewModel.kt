package com.example.teamties.feature.employees.presentation.viewmodel
import androidx.lifecycle.SavedStateHandle
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.teamties.feature.employees.domain.usecase.GetEmployeeByIdUseCase
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.SharingStarted
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.flow
import kotlinx.coroutines.flow.stateIn
import javax.inject.Inject
@HiltViewModel
class EmployeeProfileViewModel @Inject constructor(
    private val getEmployeeByIdUseCase: GetEmployeeByIdUseCase,
    savedStateHandle: SavedStateHandle
) : ViewModel() {
    private val employeeId: String = checkNotNull(savedStateHandle["employeeId"])
    val uiState: StateFlow<EmployeeProfileUiState> = flow {
        emit(EmployeeProfileUiState.Loading)
        val employee = getEmployeeByIdUseCase(employeeId)
        if (employee != null) {
            emit(EmployeeProfileUiState.Success(employee))
        } else {
            emit(EmployeeProfileUiState.Error("Employee not found"))
        }
    }.stateIn(
        scope = viewModelScope,
        started = SharingStarted.WhileSubscribed(5000),
        initialValue = EmployeeProfileUiState.Loading
    )
}
