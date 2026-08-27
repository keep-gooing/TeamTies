package com.example.teamties.feature.wiki.di

import com.example.teamties.feature.wiki.data.repository.FakeWikiRepositoryImpl
import com.example.teamties.feature.wiki.domain.repository.WikiRepository
import dagger.Binds
import dagger.Module
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
abstract class WikiModule {

    @Binds
    @Singleton
    abstract fun bindWikiRepository(
        wikiRepositoryImpl: FakeWikiRepositoryImpl
    ): WikiRepository
}
