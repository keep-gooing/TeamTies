package com.example.teamties.feature.wiki.domain.usecase

import com.example.teamties.core.model.WikiArticle
import com.example.teamties.feature.wiki.domain.repository.WikiRepository
import javax.inject.Inject

class GetArticleDetailUseCase @Inject constructor(
    private val repository: WikiRepository
) {
    suspend operator fun invoke(articleId: String): WikiArticle? {
        return repository.getArticleDetail(articleId)
    }
}
