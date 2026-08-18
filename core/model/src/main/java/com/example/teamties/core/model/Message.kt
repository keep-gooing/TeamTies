package com.example.teamties.core.model

import java.time.Instant
data class Message(
    val id: String,
    val channelId: String,
    val senderId: String,
    val content: String,
    val timestamp: Instant = Instant.now(),
    val status: MessageStatus = MessageStatus.SENT
)
enum class MessageStatus {
    SENDING,
    SENT,
    DELIVERED,
    READ,
    FAILED
}
