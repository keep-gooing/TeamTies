package com.example.teamties.feature.employees.domain.error

import com.example.teamties.core.essentials.error.General
import com.example.teamties.core.essentials.error.GeneralError

sealed interface EmployeeError : General {
    data object EmployeeNotFound : EmployeeError
    data class Basic(val error: GeneralError) : EmployeeError
}
