package com.example.teamties.feature.chat.domain.usecase

import com.example.teamties.feature.chat.domain.repository.ChatRepository
import javax.inject.Inject

class SendMessageUseCase @Inject constructor(
    private val repository: ChatRepository
) {
    suspend operator fun invoke(channelId: String, content: String) {
        repository.sendMessage(channelId, content)
    }
}
