package com.example.teamties.core.ui.di

import com.example.teamties.core.essentials.resources.CoreStringProvider
import com.example.teamties.core.essentials.resources.StringProvider
import com.example.teamties.core.ui.resources.AndroidCoreStringProvider
import dagger.Binds
import dagger.Module
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import dagger.multibindings.ClassKey
import dagger.multibindings.IntoMap
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
abstract class StringProviderModule {

    @Binds
    @Singleton
    @IntoMap
    @ClassKey(CoreStringProvider::class)
    abstract fun bindCoreStringProvider(
        provider: AndroidCoreStringProvider
    ): StringProvider
}
