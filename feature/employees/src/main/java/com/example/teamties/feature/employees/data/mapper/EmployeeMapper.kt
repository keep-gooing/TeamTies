package com.example.teamties.feature.employees.data.mapper
import com.example.teamties.core.model.Employee
import com.example.teamties.feature.employees.data.model.EmployeeDto
fun EmployeeDto.toDomain() = Employee(
    id = id,
    name = "$firstName $lastName",
    position = position,
    email = email,
    phoneNumber = phone,
    department = dept,
    bio = biography,
    permissions = permissions,
    photoUrl = avatarUrl,
    managerName = supervisor
)
