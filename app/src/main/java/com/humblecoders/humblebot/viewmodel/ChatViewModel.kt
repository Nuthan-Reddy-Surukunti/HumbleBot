package com.humblecoders.humblebot.viewmodel

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.humblecoders.humblebot.model.ChatMessage
import com.humblecoders.humblebot.repository.ChatRepository
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.launch

class ChatViewModel : ViewModel() {
    private val repository = ChatRepository()

    private val _messages = MutableStateFlow<List<ChatMessage>>(emptyList())
    val messages: StateFlow<List<ChatMessage>> = _messages.asStateFlow()

    private val _isLoading = MutableStateFlow(false)
    val isLoading: StateFlow<Boolean> = _isLoading.asStateFlow()

    private val _error = MutableStateFlow<String?>(null)
    val error: StateFlow<String?> = _error.asStateFlow()

    fun sendMessage(text: String) {
        if (text.isBlank() || _isLoading.value) return

        // Add user message
        val userMessage = ChatMessage(text = text, isFromUser = true)
        _messages.value = _messages.value + userMessage

        // Start loading
        _isLoading.value = true
        _error.value = null

        viewModelScope.launch {
            repository.sendMessage(text)
                .onSuccess { response ->
                    // Add AI response
                    val aiMessage = ChatMessage(text = response, isFromUser = false)
                    _messages.value = _messages.value + aiMessage
                    _isLoading.value = false
                }
                .onFailure { exception ->
                    _error.value = exception.message ?: "Something went wrong. Please try again."
                    _isLoading.value = false
                }
        }
    }

    fun clearError() {
        _error.value = null
    }

    fun clearChat() {
        _messages.value = emptyList()
        _error.value = null
    }
}

