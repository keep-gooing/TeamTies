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
    role = role,
    photoUrl = avatarUrl,
    managerName = supervisor
)
