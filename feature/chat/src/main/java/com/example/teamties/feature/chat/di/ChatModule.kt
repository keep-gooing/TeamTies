package com.example.teamties.feature.chat.di

import com.example.teamties.feature.chat.data.repository.FakeChatRepositoryImpl
import com.example.teamties.feature.chat.domain.repository.ChatRepository
import dagger.Binds
import dagger.Module
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
abstract class ChatModule {

    @Binds
    @Singleton
    abstract fun bindChatRepository(
        chatRepositoryImpl: FakeChatRepositoryImpl
    ): ChatRepository
}
