package com.example.teamties.feature.chat.data.mapper

import com.example.teamties.core.model.Channel
import com.example.teamties.core.model.Message
import com.example.teamties.feature.chat.data.model.ChannelDto
import com.example.teamties.feature.chat.data.model.MessageDto

fun ChannelDto.toDomain(lastMessage: Message? = null): Channel = Channel(
    id = id,
    name = name,
    description = description,
    type = type,
    memberIds = memberIds,
    lastMessage = lastMessage
)

fun MessageDto.toDomain(): Message = Message(
    id = id,
    channelId = channelId,
    senderId = senderId,
    content = content,
    timestamp = timestamp,
    status = status
)

fun Message.toDto(): MessageDto = MessageDto(
    id = id,
    channelId = channelId,
    senderId = senderId,
    content = content,
    timestamp = timestamp,
    status = status
)
