package com.example.teamties.feature.wiki.domain.usecase

import com.example.teamties.core.model.WikiCategory
import com.example.teamties.feature.wiki.domain.repository.WikiRepository
import javax.inject.Inject

//rebase practice
//stash practice
//cherry-pick
// temporary change for cherry-pick
// temporary change for cherry-pick 2.0
//change list
//part 1 to Squash
//part 2 to Squash
//temp 1

class GetWikiCategoriesUseCase @Inject constructor(
    private val repository: WikiRepository
) {
    suspend operator fun invoke(): List<WikiCategory> {
        return repository.getWikiCategories()
    }
}
