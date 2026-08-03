package com.example.teamties.feature.employees.data.model
data class EmployeeDto(
    val id: String,
    val firstName: String,
    val lastName: String,
    val role: String,
    val email: String,
    val phone: String,
    val dept: String,
    val biography: String,
    val avatarUrl: String? = null,
    val supervisor: String? = null
)
