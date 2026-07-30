package com.example.teamties.feature.employees.di

import com.example.teamties.feature.employees.data.repository.FakeEmployeeRepositoryImpl
import com.example.teamties.feature.employees.domain.repository.EmployeeRepository
import dagger.Binds
import dagger.Module
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
abstract class EmployeeModule {

    @Binds
    @Singleton
    abstract fun bindEmployeeRepository(
        employeeRepositoryImpl: FakeEmployeeRepositoryImpl
    ): EmployeeRepository
}
