package com.example.teamties.feature.chat.domain.usecase

import com.example.teamties.core.model.Message
import com.example.teamties.feature.chat.domain.repository.ChatRepository
import kotlinx.coroutines.flow.Flow
import javax.inject.Inject

class ObserveMessagesUseCase @Inject constructor(
    private val repository: ChatRepository
) {
    operator fun invoke(channelId: String): Flow<List<Message>> = 
        repository.observeMessages(channelId)
}
