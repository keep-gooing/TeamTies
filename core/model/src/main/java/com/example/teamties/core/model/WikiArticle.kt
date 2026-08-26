package com.example.teamties.core.model

data class WikiArticle(
    val id: String,
    val categoryId: String,
    val title: String,
    val content: String,
    val authorId: String,
    val lastModified: Long
)
