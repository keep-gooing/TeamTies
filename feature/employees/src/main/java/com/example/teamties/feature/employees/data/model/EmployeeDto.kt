package com.example.teamties.feature.employees.data.model
import com.example.teamties.core.model.AppPermission

data class EmployeeDto(
    val id: String,
    val firstName: String,
    val lastName: String,
    val position: String,
    val email: String,
    val phone: String,
    val dept: String,
    val biography: String,
    val permissions: Set<AppPermission> = emptySet(),
    val avatarUrl: String? = null,
    val supervisor: String? = null
)
