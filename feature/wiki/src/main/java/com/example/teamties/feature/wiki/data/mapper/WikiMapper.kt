package com.example.teamties.feature.wiki.data.mapper

import com.example.teamties.core.model.WikiArticle
import com.example.teamties.core.model.WikiCategory
import com.example.teamties.feature.wiki.data.model.WikiArticleDto
import com.example.teamties.feature.wiki.data.model.WikiCategoryDto

fun WikiCategoryDto.toDomain(): WikiCategory {
    return WikiCategory(
        id = id,
        name = name,
        description = description,
        iconUrl = iconUrl
    )
}

fun WikiArticleDto.toDomain(): WikiArticle {
    return WikiArticle(
        id = id,
        categoryId = categoryId,
        title = title,
        content = content,
        authorId = authorId,
        lastModified = lastModified
    )
}
