package com.example.teamties.core.model

data class ChatSession(
    val channelId: String,
    val isActive: Boolean = false,
    val connectionState: ConnectionState = ConnectionState.DISCONNECTED
)

enum class ConnectionState {
    CONNECTED,
    CONNECTING,
    DISCONNECTED,
    ERROR
}
