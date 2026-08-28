package com.example.teamties.feature.wiki.presentation.home

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.teamties.core.model.WikiArticle
import com.example.teamties.core.model.WikiCategory
import com.example.teamties.feature.wiki.domain.usecase.GetArticlesByCategoryUseCase
import com.example.teamties.feature.wiki.domain.usecase.GetWikiCategoriesUseCase
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.*
import kotlinx.coroutines.launch
import javax.inject.Inject

data class WikiHomeUiState(
    val categories: List<WikiCategory> = emptyList(),
    val articlesByCategory: Map<String, List<WikiArticle>> = emptyMap(),
    val isLoading: Boolean = false,
    val error: String? = null
)

@HiltViewModel
class WikiHomeViewModel @Inject constructor(
    private val getWikiCategoriesUseCase: GetWikiCategoriesUseCase,
    private val getArticlesByCategoryUseCase: GetArticlesByCategoryUseCase
) : ViewModel() {

    private val _uiState = MutableStateFlow(WikiHomeUiState())
    val uiState: StateFlow<WikiHomeUiState> = _uiState.asStateFlow()

    init {
        loadData()
    }

    private fun loadData() {
        viewModelScope.launch {
            _uiState.update { it.copy(isLoading = true, error = null) }
            try {
                val categories = getWikiCategoriesUseCase()
                _uiState.update { it.copy(categories = categories) }
                
                categories.forEach { category ->
                    loadArticlesForCategory(category.id)
                }
                _uiState.update { it.copy(isLoading = false) }
            } catch (e: Exception) {
                _uiState.update { it.copy(isLoading = false, error = e.message) }
            }
        }
    }

    private fun loadArticlesForCategory(categoryId: String) {
        viewModelScope.launch {
            try {
                val articles = getArticlesByCategoryUseCase(categoryId)
                _uiState.update { state ->
                    state.copy(
                        articlesByCategory = state.articlesByCategory + (categoryId to articles)
                    )
                }
            } catch (e: Exception) {
                // Articles for a specific category failed, but we might not want to show a global error
                // For now, we just log it or ignore it, as categories are loaded
            }
        }
    }
}
