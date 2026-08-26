package com.example.teamties.feature.chat.domain.usecase

import com.example.teamties.core.model.Channel
import com.example.teamties.feature.chat.domain.repository.ChatRepository
import kotlinx.coroutines.flow.Flow
import javax.inject.Inject

class GetChannelsUseCase @Inject constructor(
    private val repository: ChatRepository
) {
    operator fun invoke(): Flow<List<Channel>> = repository.getChannels()
}
