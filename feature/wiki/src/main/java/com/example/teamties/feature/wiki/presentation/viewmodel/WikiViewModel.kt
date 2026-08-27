package com.example.teamties.feature.wiki.presentation.viewmodel

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.teamties.core.model.WikiArticle
import com.example.teamties.core.model.WikiCategory
import com.example.teamties.feature.wiki.domain.usecase.GetArticleDetailUseCase
import com.example.teamties.feature.wiki.domain.usecase.GetWikiCategoriesUseCase
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.*
import kotlinx.coroutines.launch
import javax.inject.Inject

data class WikiUiState(
    val categories: List<WikiCategory> = emptyList(),
    val articlesByCategory: Map<String, List<WikiArticle>> = emptyMap(),
    val isLoading: Boolean = false,
    val selectedArticle: WikiArticle? = null,
    val error: String? = null
)

@HiltViewModel
class WikiViewModel @Inject constructor(
    private val getWikiCategoriesUseCase: GetWikiCategoriesUseCase,
    private val getArticlesByCategoryUseCase: com.example.teamties.feature.wiki.domain.usecase.GetArticlesByCategoryUseCase,
    private val getArticleDetailUseCase: GetArticleDetailUseCase
) : ViewModel() {

    private val _uiState = MutableStateFlow(WikiUiState())
    val uiState: StateFlow<WikiUiState> = _uiState.asStateFlow()

    init {
        loadData()
    }

    private fun loadData() {
        viewModelScope.launch {
            _uiState.update { it.copy(isLoading = true) }
            getWikiCategoriesUseCase()
                .catch { e ->
                    _uiState.update { it.copy(isLoading = false, error = e.message) }
                }
                .collect { categories ->
                    _uiState.update { it.copy(categories = categories) }
                    categories.forEach { category ->
                        loadArticlesForCategory(category.id)
                    }
                    _uiState.update { it.copy(isLoading = false) }
                }
        }
    }

    private fun loadArticlesForCategory(categoryId: String) {
        viewModelScope.launch {
            getArticlesByCategoryUseCase(categoryId)
                .collect { articles ->
                    _uiState.update { state ->
                        state.copy(
                            articlesByCategory = state.articlesByCategory + (categoryId to articles)
                        )
                    }
                }
        }
    }

    fun loadArticle(articleId: String) {
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
