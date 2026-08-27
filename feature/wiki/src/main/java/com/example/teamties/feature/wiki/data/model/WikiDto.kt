package com.example.teamties.feature.wiki.data.model

data class WikiCategoryDto(
    val id: String,
    val name: String,
    val description: String,
    val iconUrl: String? = null
)

data class WikiArticleDto(
    val id: String,
    val categoryId: String,
    val title: String,
    val content: String,
    val authorId: String,
    val lastModified: Long
)
