package com.example.teamties.feature.wiki.domain.usecase

import com.example.teamties.core.model.WikiArticle
import com.example.teamties.feature.wiki.domain.repository.WikiRepository
import kotlinx.coroutines.flow.Flow
import javax.inject.Inject

class GetArticlesByCategoryUseCase @Inject constructor(
    private val repository: WikiRepository
) {
    operator fun invoke(categoryId: String): Flow<List<WikiArticle>> {
        return repository.getArticlesByCategory(categoryId)
    }
}
