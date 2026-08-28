package com.example.teamties.feature.wiki.domain.usecase

import com.example.teamties.core.model.WikiArticle
import com.example.teamties.feature.wiki.domain.repository.WikiRepository
import javax.inject.Inject

class GetArticlesByCategoryUseCase @Inject constructor(
    private val repository: WikiRepository
) {
    suspend operator fun invoke(categoryId: String): List<WikiArticle> {
        return repository.getArticlesByCategory(categoryId)
    }
}
