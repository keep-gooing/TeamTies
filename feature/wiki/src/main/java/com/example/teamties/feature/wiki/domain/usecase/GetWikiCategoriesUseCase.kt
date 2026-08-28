package com.example.teamties.feature.wiki.domain.usecase

import com.example.teamties.core.model.WikiCategory
import com.example.teamties.feature.wiki.domain.repository.WikiRepository
import javax.inject.Inject

//rebase practice
class GetWikiCategoriesUseCase @Inject constructor(
    private val repository: WikiRepository
) {
    suspend operator fun invoke(): List<WikiCategory> {
        return repository.getWikiCategories()
    }
}
