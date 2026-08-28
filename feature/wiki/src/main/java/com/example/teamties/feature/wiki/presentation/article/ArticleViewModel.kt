package com.example.teamties.feature.wiki.presentation.article

import androidx.lifecycle.SavedStateHandle
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.teamties.core.model.WikiArticle
import com.example.teamties.feature.wiki.domain.usecase.GetArticleDetailUseCase
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.*
import kotlinx.coroutines.launch
import javax.inject.Inject

data class ArticleUiState(
    val selectedArticle: WikiArticle? = null,
    val isLoading: Boolean = false,
    val error: String? = null
)

@HiltViewModel
class ArticleViewModel @Inject constructor(
    private val getArticleDetailUseCase: GetArticleDetailUseCase,
    savedStateHandle: SavedStateHandle
) : ViewModel() {

    private val _uiState = MutableStateFlow(ArticleUiState())
    val uiState: StateFlow<ArticleUiState> = _uiState.asStateFlow()

    init {
        savedStateHandle.get<String>("articleId")?.let { id ->
            fetchArticle(id)
        }
    }

    private fun fetchArticle(articleId: String) {
        viewModelScope.launch {
            _uiState.update { it.copy(isLoading = true, selectedArticle = null) }
            try {
                val article = getArticleDetailUseCase(articleId)
                _uiState.update { it.copy(isLoading = false, selectedArticle = article) }
            } catch (e: Exception) {
                _uiState.update { it.copy(isLoading = false, error = e.message) }
            }
        }
    }
}
