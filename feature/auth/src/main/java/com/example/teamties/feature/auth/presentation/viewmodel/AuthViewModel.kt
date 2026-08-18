package com.example.teamties.feature.auth.presentation.viewmodel
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.teamties.core.essentials.error.onError
import com.example.teamties.core.essentials.error.onSuccess
import com.example.teamties.core.model.Employee
import com.example.teamties.feature.auth.domain.usecase.CheckSessionUseCase
import com.example.teamties.feature.auth.domain.usecase.LoginUseCase
import com.example.teamties.feature.auth.domain.usecase.LogoutUseCase
import com.example.teamties.feature.auth.presentation.mapper.AuthErrorMapper
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
    private val authErrorMapper: AuthErrorMapper
) : ViewModel() {
    private val _authState = MutableStateFlow<AuthState>(AuthState.Unauthenticated)
    val authState: StateFlow<AuthState> = _authState.asStateFlow()
    init {
        checkSession()
    }
    fun login(email: String, password: String) {
        viewModelScope.launch {
            _authState.value = AuthState.Loading
            loginUseCase(email, password)
                .onSuccess { user ->
                    _authState.value = AuthState.Authenticated(user)
                }
                .onError { error ->
                    _authState.value = AuthState.Error(
                        authErrorMapper.map(error)
                    )
                }
        }
    }

    fun logout() {
        viewModelScope.launch {
            _authState.value = AuthState.Loading
            logoutUseCase()
                .onSuccess {
                    _authState.value = AuthState.Unauthenticated
                }
                .onError { error ->
                    _authState.value = AuthState.Error(
                        authErrorMapper.map(error)
                    )
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
