package com.example.teamties.feature.wiki.presentation.home

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.teamties.core.model.WikiArticle
import com.example.teamties.core.model.WikiCategory
import com.example.teamties.feature.wiki.domain.usecase.GetArticlesByCategoryUseCase
import com.example.teamties.feature.wiki.domain.usecase.GetWikiCategoriesUseCase
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.async
import kotlinx.coroutines.awaitAll
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.flow.update
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
                val articlesMap = categories.map { category ->
                    async {
                        category.id to getArticlesByCategoryUseCase(category.id)
                    }
                }.awaitAll().toMap()

                _uiState.update { 
                    it.copy(
                        categories = categories,
                        articlesByCategory = articlesMap,
                        isLoading = false
                    )
                }
            } catch (e: Exception) {
                _uiState.update { it.copy(isLoading = false, error = e.message) }
            }
        }
    }
}
