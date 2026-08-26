package com.example.teamties.feature.chat.data.model

import com.example.teamties.core.model.MessageStatus
import java.time.Instant

data class MessageDto(
    val id: String,
    val channelId: String,
    val senderId: String,
    val content: String,
    val timestamp: Instant,
    val status: MessageStatus
)
