package com.example.teamties.core.model
data class Employee(
    val id: String,
    val name: String,
    val position: String,
    val email: String,
    val phoneNumber: String,
    val department: String,
    val bio: String,
    val permissions: Set<AppPermission> = emptySet(),
    val photoUrl: String? = null,
    val managerName: String? = null
)