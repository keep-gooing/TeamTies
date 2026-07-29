package com.example.teamties.core.essentials.di

import com.example.teamties.core.essentials.exceptions.mapper.DefaultExceptionToMessageMapper
import com.example.teamties.core.essentials.exceptions.mapper.ExceptionToMessageMapper
import dagger.Binds
import dagger.Module
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
abstract class EssentialsModule {

    @Binds
    @Singleton
    abstract fun bindExceptionToMessageMapper(
        mapper: DefaultExceptionToMessageMapper
    ): ExceptionToMessageMapper
}
