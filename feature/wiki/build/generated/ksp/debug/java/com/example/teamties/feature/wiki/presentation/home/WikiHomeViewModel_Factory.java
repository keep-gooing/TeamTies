package com.example.teamties.feature.wiki.presentation.home;

import com.example.teamties.feature.wiki.domain.usecase.GetArticlesByCategoryUseCase;
import com.example.teamties.feature.wiki.domain.usecase.GetWikiCategoriesUseCase;
import dagger.internal.DaggerGenerated;
import dagger.internal.Factory;
import dagger.internal.Provider;
import dagger.internal.QualifierMetadata;
import dagger.internal.ScopeMetadata;
import javax.annotation.processing.Generated;

@ScopeMetadata
@QualifierMetadata
@DaggerGenerated
@Generated(
    value = "dagger.internal.codegen.ComponentProcessor",
    comments = "https://dagger.dev"
)
@SuppressWarnings({
    "unchecked",
    "rawtypes",
    "KotlinInternal",
    "KotlinInternalInJava",
    "cast",
    "deprecation",
    "nullness:initialization.field.uninitialized"
})
public final class WikiHomeViewModel_Factory implements Factory<WikiHomeViewModel> {
  private final Provider<GetWikiCategoriesUseCase> getWikiCategoriesUseCaseProvider;

  private final Provider<GetArticlesByCategoryUseCase> getArticlesByCategoryUseCaseProvider;

  private WikiHomeViewModel_Factory(
      Provider<GetWikiCategoriesUseCase> getWikiCategoriesUseCaseProvider,
      Provider<GetArticlesByCategoryUseCase> getArticlesByCategoryUseCaseProvider) {
    this.getWikiCategoriesUseCaseProvider = getWikiCategoriesUseCaseProvider;
    this.getArticlesByCategoryUseCaseProvider = getArticlesByCategoryUseCaseProvider;
  }

  @Override
  public WikiHomeViewModel get() {
    return newInstance(getWikiCategoriesUseCaseProvider.get(), getArticlesByCategoryUseCaseProvider.get());
  }

  public static WikiHomeViewModel_Factory create(
      Provider<GetWikiCategoriesUseCase> getWikiCategoriesUseCaseProvider,
      Provider<GetArticlesByCategoryUseCase> getArticlesByCategoryUseCaseProvider) {
    return new WikiHomeViewModel_Factory(getWikiCategoriesUseCaseProvider, getArticlesByCategoryUseCaseProvider);
  }

  public static WikiHomeViewModel newInstance(GetWikiCategoriesUseCase getWikiCategoriesUseCase,
      GetArticlesByCategoryUseCase getArticlesByCategoryUseCase) {
    return new WikiHomeViewModel(getWikiCategoriesUseCase, getArticlesByCategoryUseCase);
  }
}
