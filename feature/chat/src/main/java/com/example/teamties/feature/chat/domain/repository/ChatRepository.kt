package com.example.teamties.feature.chat.domain.repository

import com.example.teamties.core.model.Channel
import com.example.teamties.core.model.Message
import kotlinx.coroutines.flow.Flow

interface ChatRepository {
    fun getChannels(): Flow<List<Channel>>
    fun observeMessages(channelId: String): Flow<List<Message>>
    suspend fun sendMessage(channelId: String, content: String)
}
