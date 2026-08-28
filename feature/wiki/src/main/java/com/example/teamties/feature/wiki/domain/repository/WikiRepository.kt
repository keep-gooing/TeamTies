package com.example.teamties.feature.wiki.domain.repository

import com.example.teamties.core.model.WikiArticle
import com.example.teamties.core.model.WikiCategory

interface WikiRepository {
    suspend fun getWikiCategories(): List<WikiCategory>
    suspend fun getArticlesByCategory(categoryId: String): List<WikiArticle>
    suspend fun getArticleDetail(articleId: String): WikiArticle?
}
