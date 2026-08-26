package com.example.teamties.feature.chat.presentation.viewmodel

import com.example.teamties.core.model.Channel
import com.example.teamties.core.model.Message

data class ChannelListUiState(
    val channels: List<Channel> = emptyList(),
    val isLoading: Boolean = false,
    val error: String? = null
)

data class ChatUiState(
    val channel: Channel? = null,
    val messages: List<Message> = emptyList(),
    val isLoading: Boolean = false,
    val error: String? = null
)
