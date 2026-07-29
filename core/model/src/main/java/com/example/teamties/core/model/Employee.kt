package com.example.teamties.core.model

data class Employee(
    val id: String,
    val name: String,
    val position: String,
    val email: String,
    val department: String,
    val photoUrl: String? = null
)
