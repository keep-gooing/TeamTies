package com.example.teamties.feature.wiki.data.repository

import com.example.teamties.core.model.WikiArticle
import com.example.teamties.core.model.WikiCategory
import com.example.teamties.feature.wiki.data.mapper.toDomain
import com.example.teamties.feature.wiki.data.model.WikiArticleDto
import com.example.teamties.feature.wiki.data.model.WikiCategoryDto
import com.example.teamties.feature.wiki.domain.repository.WikiRepository
import kotlinx.coroutines.flow.MutableStateFlow
import javax.inject.Inject
import javax.inject.Singleton

@Singleton
class FakeWikiRepositoryImpl @Inject constructor() : WikiRepository {
    private val _categories = MutableStateFlow(listOf(
        WikiCategoryDto("1", "Onboarding", "Essential info for new joiners"),
        WikiCategoryDto("2", "Benefits", "Health, 401k, and other perks"),
        WikiCategoryDto("3", "Engineering", "Technical documentation and guidelines"),
        WikiCategoryDto("4", "Security", "Security policies and procedures")
    ))

    private val _articles = MutableStateFlow(listOf(
        WikiArticleDto(
            "1", "1", "Welcome to TeamTies",
            "We're glad you're here. This article covers your first day...",
            "admin", System.currentTimeMillis()
        ),
        WikiArticleDto(
            "2", "3", "Clean Architecture Guide",
            "Our Android projects follow Clean Architecture strictly. Here is how...",
            "sarah_chen", System.currentTimeMillis()
        ),
        WikiArticleDto(
            "3", "2", "Health Insurance 2024",
            "Details on the current year's health insurance options...",
            "hr_specialist", System.currentTimeMillis()
        )
    ))

    override suspend fun getWikiCategories(): List<WikiCategory> {
        return _categories.value.map { it.toDomain() }
    }

    override suspend fun getArticlesByCategory(categoryId: String): List<WikiArticle> {
        return _articles.value
            .filter { it.categoryId == categoryId }
            .map { it.toDomain() }
    }

    override suspend fun getArticleDetail(articleId: String): WikiArticle? {
        return _articles.value.find { it.id == articleId }?.toDomain()
    }
}
