package com.example.teamties.di

import com.example.teamties.data.repository.FakeEmployeeRepositoryImpl
import com.example.teamties.domain.repository.EmployeeRepository
import dagger.Binds
import dagger.Module
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
abstract class RepositoryModule {

    @Binds
    @Singleton
    abstract fun bindEmployeeRepository(
        fakeEmployeeRepositoryImpl: FakeEmployeeRepositoryImpl
    ): EmployeeRepository
}
