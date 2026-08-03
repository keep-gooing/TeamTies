package com.example.teamties.feature.employees.presentation.viewmodel
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.teamties.feature.employees.domain.usecase.GetEmployeesUseCase
import com.example.teamties.feature.employees.domain.usecase.SearchEmployeesUseCase
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.ExperimentalCoroutinesApi
import kotlinx.coroutines.FlowPreview
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.SharingStarted
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.flow.catch
import kotlinx.coroutines.flow.debounce
import kotlinx.coroutines.flow.distinctUntilChanged
import kotlinx.coroutines.flow.flatMapLatest
import kotlinx.coroutines.flow.map
import kotlinx.coroutines.flow.stateIn
import javax.inject.Inject
import kotlin.time.Duration.Companion.milliseconds
@OptIn(ExperimentalCoroutinesApi::class, FlowPreview::class)
@HiltViewModel
class EmployeeViewModel @Inject constructor(
    private val getEmployeesUseCase: GetEmployeesUseCase,
    private val searchEmployeesUseCase: SearchEmployeesUseCase
) : ViewModel() {
    private val _searchQuery = MutableStateFlow("")
    val searchQuery: StateFlow<String> = _searchQuery.asStateFlow()
    val uiState: StateFlow<DirectoryUiState> = _searchQuery
        .debounce(300.milliseconds)
        .distinctUntilChanged()
        .flatMapLatest { query ->
            if (query.isBlank()) {
                getEmployeesUseCase()
            } else {
                searchEmployeesUseCase(query)
            }
        }
        .map { employees ->
            if (employees.isEmpty()) {
                DirectoryUiState.Empty
            } else {
                DirectoryUiState.Success(employees)
            }
        }
        .catch {
            emit(DirectoryUiState.Error("Failed to load employees"))
        }
        .stateIn(
            scope = viewModelScope,
            started = SharingStarted.WhileSubscribed(5000),
            initialValue = DirectoryUiState.Loading
        )
    fun onSearchQueryChange(newQuery: String) {
        _searchQuery.value = newQuery
    }
}
