package com.example.teamties.feature.auth.presentation.viewmodel
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.teamties.core.model.Employee
import com.example.teamties.core.essentials.exceptions.mapper.ExceptionToMessageMapper
import com.example.teamties.feature.auth.domain.usecase.CheckSessionUseCase
import com.example.teamties.feature.auth.domain.usecase.LoginUseCase
import com.example.teamties.feature.auth.domain.usecase.LogoutUseCase
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.launch
import javax.inject.Inject
@HiltViewModel
class AuthViewModel @Inject constructor(
    private val loginUseCase: LoginUseCase,
    private val logoutUseCase: LogoutUseCase,
    private val checkSessionUseCase: CheckSessionUseCase,
    private val exceptionToMessageMapper: ExceptionToMessageMapper
) : ViewModel() {
    private val _authState = MutableStateFlow<AuthState>(AuthState.Unauthenticated)
    val authState: StateFlow<AuthState> = _authState.asStateFlow()
    init {
        checkSession()
    }
    fun login(email: String, password: String) {
        viewModelScope.launch {
            _authState.value = AuthState.Loading
            loginUseCase(email, password).collect { result ->
                result.onSuccess { user ->
                    _authState.value = AuthState.Authenticated(user)
                }.onFailure { exception ->
                    _authState.value = AuthState.Error(
                        exceptionToMessageMapper.getLocalizedMessage(exception)
                    )
                }
            }
        }
    }
    fun logout() {
        viewModelScope.launch {
            _authState.value = AuthState.Loading
            logoutUseCase().collect { result ->
                result.onSuccess {
                    _authState.value = AuthState.Unauthenticated
                }.onFailure { exception ->
                    _authState.value = AuthState.Error(
                        exceptionToMessageMapper.getLocalizedMessage(exception)
                    )
                }
            }
        }
    }
    private fun checkSession() {
        viewModelScope.launch {
            checkSessionUseCase().collect { isAuthenticated ->
                if (!isAuthenticated) {
                    _authState.value = AuthState.Unauthenticated
                }
            }
        }
    }
}
sealed interface AuthState {
    data object Loading : AuthState
    data class Authenticated(val user: Employee) : AuthState
    data object Unauthenticated : AuthState
    data class Error(val message: String) : AuthState
}
