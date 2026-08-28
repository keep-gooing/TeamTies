package com.example.teamties.feature.chat.presentation.viewmodel

import androidx.lifecycle.SavedStateHandle
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.teamties.feature.chat.domain.usecase.GetChannelsUseCase
import com.example.teamties.feature.chat.domain.usecase.ObserveMessagesUseCase
import com.example.teamties.feature.chat.domain.usecase.SendMessageUseCase
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.*
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class ChatViewModel @Inject constructor(
    private val getChannelsUseCase: GetChannelsUseCase,
    private val observeMessagesUseCase: ObserveMessagesUseCase,
    private val sendMessageUseCase: SendMessageUseCase,
    private val savedStateHandle: SavedStateHandle
) : ViewModel() {

    private val _channelListState = MutableStateFlow(ChannelListUiState())
    val channelListState: StateFlow<ChannelListUiState> = _channelListState.asStateFlow()

    private val _chatState = MutableStateFlow(ChatUiState())
    val chatState: StateFlow<ChatUiState> = _chatState.asStateFlow()

    init {
        loadChannels()
        savedStateHandle.get<String>("channelId")?.let { channelId ->
            observeChannel(channelId)
        }
    }

    fun loadChannels() {
        getChannelsUseCase()
            .onStart { _channelListState.update { it.copy(isLoading = true) } }
            .onEach { channels ->
                _channelListState.update { it.copy(channels = channels, isLoading = false) }
            }
            .catch { e ->
                _channelListState.update { it.copy(error = e.message, isLoading = false) }
            }
            .launchIn(viewModelScope)
    }

    fun observeChannel(channelId: String) {
        observeMessagesUseCase(channelId)
            .onStart { _chatState.update { it.copy(isLoading = true) } }
            .onEach { messages ->
                _chatState.update { it.copy(messages = messages, isLoading = false) }
            }
            .catch { e ->
                _chatState.update { it.copy(error = e.message, isLoading = false) }
            }
            .launchIn(viewModelScope)

        viewModelScope.launch {
            getChannelsUseCase().firstOrNull()?.find { it.id == channelId }?.let { channel ->
                _chatState.update { it.copy(channel = channel) }
            }
        }
    }

    fun sendMessage(content: String) {
        val channelId = _chatState.value.channel?.id ?: return
        if (content.isBlank()) return
        
        viewModelScope.launch {
            try {
                sendMessageUseCase(channelId, content)
            } catch (e: Exception) {
                _chatState.update { it.copy(error = e.message) }
            }
        }
    }
}
