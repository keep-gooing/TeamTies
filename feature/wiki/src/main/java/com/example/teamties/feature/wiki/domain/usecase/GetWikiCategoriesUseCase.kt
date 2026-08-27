package com.example.teamties.feature.wiki.domain.usecase

import com.example.teamties.core.model.WikiCategory
import com.example.teamties.feature.wiki.domain.repository.WikiRepository
import kotlinx.coroutines.flow.Flow
import javax.inject.Inject

class GetWikiCategoriesUseCase @Inject constructor(
    private val repository: WikiRepository
) {
    operator fun invoke(): Flow<List<WikiCategory>> {
        return repository.getWikiCategories()
    }
}
