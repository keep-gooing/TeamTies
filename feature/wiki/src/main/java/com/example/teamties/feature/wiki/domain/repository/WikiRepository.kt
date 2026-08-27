package com.example.teamties.feature.wiki.domain.repository

import com.example.teamties.core.model.WikiArticle
import com.example.teamties.core.model.WikiCategory
import kotlinx.coroutines.flow.Flow

interface WikiRepository {
    fun getWikiCategories(): Flow<List<WikiCategory>>
    fun getArticlesByCategory(categoryId: String): Flow<List<WikiArticle>>
    suspend fun getArticleDetail(articleId: String): WikiArticle?
}
