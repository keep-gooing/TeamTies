package com.example.teamties.feature.chat.data.repository

import com.example.teamties.core.model.Channel
import com.example.teamties.core.model.ChannelType
import com.example.teamties.core.model.Message
import com.example.teamties.core.model.MessageStatus
import com.example.teamties.feature.chat.data.mapper.toDomain
import com.example.teamties.feature.chat.data.model.ChannelDto
import com.example.teamties.feature.chat.data.model.MessageDto
import com.example.teamties.feature.chat.domain.repository.ChatRepository
import kotlinx.coroutines.delay
import kotlinx.coroutines.flow.*
import java.time.Instant
import java.util.*
import javax.inject.Inject
import javax.inject.Singleton

@Singleton
class FakeChatRepositoryImpl @Inject constructor() : ChatRepository {

    private val _channels = MutableStateFlow(listOf(
        ChannelDto("1", "General", "Company-wide announcements", ChannelType.PUBLIC, listOf("1", "2", "3", "4", "5")),
        ChannelDto("2", "Engineering", "Tech discussions", ChannelType.PUBLIC, listOf("1", "4", "8")),
        ChannelDto("3", "Design", "UI/UX feedback", ChannelType.PUBLIC, listOf("2", "3")),
        ChannelDto("4", "Direct: Sarah Chen", null, ChannelType.DIRECT, listOf("current_user", "1"))
    ))

    private val _messages = MutableStateFlow<Map<String, List<MessageDto>>>(
        mapOf(
            "1" to listOf(
                MessageDto(UUID.randomUUID().toString(), "1", "4", "Welcome to the team!", Instant.now().minusSeconds(3600), MessageStatus.READ)
            ),
            "2" to listOf(
                MessageDto(UUID.randomUUID().toString(), "2", "1", "Did anyone review the PR?", Instant.now().minusSeconds(1800), MessageStatus.READ)
            )
        )
    )

    override fun getChannels(): Flow<List<Channel>> {
        return combine(_channels, _messages) { channels, messages ->
            channels.map { dto ->
                val lastMsgDto = messages[dto.id]?.lastOrNull()
                dto.toDomain(lastMsgDto?.toDomain())
            }
        }
    }

    override fun observeMessages(channelId: String): Flow<List<Message>> {
        return _messages.map { messages ->
            messages[channelId]?.map { it.toDomain() } ?: emptyList()
        }
    }

    override suspend fun sendMessage(channelId: String, content: String) {
        val newMessage = MessageDto(
            id = UUID.randomUUID().toString(),
            channelId = channelId,
            senderId = "current_user",
            content = content,
            timestamp = Instant.now(),
            status = MessageStatus.SENT
        )

        updateMessages(channelId, newMessage)

        // Simulate delivery and read status
        delay(500)
        updateMessageStatus(channelId, newMessage.id, MessageStatus.DELIVERED)
        delay(1000)
        updateMessageStatus(channelId, newMessage.id, MessageStatus.READ)

        // Simple bot response simulation
        if (content.contains("hello", ignoreCase = true)) {
            delay(1000)
            sendBotResponse(channelId, "Hello! How can I help you today?")
        }
    }

    private fun updateMessages(channelId: String, newMessage: MessageDto) {
        val currentMap = _messages.value.toMutableMap()
        val currentList = currentMap[channelId]?.toMutableList() ?: mutableListOf()
        currentList.add(newMessage)
        currentMap[channelId] = currentList
        _messages.value = currentMap
    }

    private fun updateMessageStatus(channelId: String, messageId: String, status: MessageStatus) {
        val currentMap = _messages.value.toMutableMap()
        val currentList = currentMap[channelId]?.toMutableList() ?: return
        val index = currentList.indexOfFirst { it.id == messageId }
        if (index != -1) {
            currentList[index] = currentList[index].copy(status = status)
            currentMap[channelId] = currentList
            _messages.value = currentMap
        }
    }

    private fun sendBotResponse(channelId: String, content: String) {
        val botMessage = MessageDto(
            id = UUID.randomUUID().toString(),
            channelId = channelId,
            senderId = "bot",
            content = content,
            timestamp = Instant.now(),
            status = MessageStatus.SENT
        )
        updateMessages(channelId, botMessage)
    }
}
