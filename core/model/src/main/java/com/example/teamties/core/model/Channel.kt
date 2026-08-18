package com.example.teamties.core.model

data class Channel(
    val id: String,
    val name: String,
    val description: String?,
    val type: ChannelType,
    val memberIds: List<String> = emptyList(),
    val lastMessage: Message? = null
)

enum class ChannelType {
    PUBLIC,
    PRIVATE,
    DIRECT
}
