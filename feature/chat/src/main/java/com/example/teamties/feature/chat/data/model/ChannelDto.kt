package com.example.teamties.feature.chat.data.model

import com.example.teamties.core.model.ChannelType

data class ChannelDto(
    val id: String,
    val name: String,
    val description: String?,
    val type: ChannelType,
    val memberIds: List<String> = emptyList()
)
