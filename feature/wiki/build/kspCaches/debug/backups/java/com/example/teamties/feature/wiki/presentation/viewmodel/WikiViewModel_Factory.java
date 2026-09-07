package com.example.teamties.feature.wiki.presentation.viewmodel;

import com.example.teamties.feature.wiki.domain.usecase.GetArticleDetailUseCase;
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
public final class WikiViewModel_Factory implements Factory<WikiViewModel> {
  private final Provider<GetWikiCategoriesUseCase> getWikiCategoriesUseCaseProvider;

  private final Provider<GetArticlesByCategoryUseCase> getArticlesByCategoryUseCaseProvider;

  private final Provider<GetArticleDetailUseCase> getArticleDetailUseCaseProvider;

  private WikiViewModel_Factory(Provider<GetWikiCategoriesUseCase> getWikiCategoriesUseCaseProvider,
      Provider<GetArticlesByCategoryUseCase> getArticlesByCategoryUseCaseProvider,
      Provider<GetArticleDetailUseCase> getArticleDetailUseCaseProvider) {
    this.getWikiCategoriesUseCaseProvider = getWikiCategoriesUseCaseProvider;
    this.getArticlesByCategoryUseCaseProvider = getArticlesByCategoryUseCaseProvider;
    this.getArticleDetailUseCaseProvider = getArticleDetailUseCaseProvider;
  }

  @Override
  public WikiViewModel get() {
    return newInstance(getWikiCategoriesUseCaseProvider.get(), getArticlesByCategoryUseCaseProvider.get(), getArticleDetailUseCaseProvider.get());
  }

  public static WikiViewModel_Factory create(
      Provider<GetWikiCategoriesUseCase> getWikiCategoriesUseCaseProvider,
      Provider<GetArticlesByCategoryUseCase> getArticlesByCategoryUseCaseProvider,
      Provider<GetArticleDetailUseCase> getArticleDetailUseCaseProvider) {
    return new WikiViewModel_Factory(getWikiCategoriesUseCaseProvider, getArticlesByCategoryUseCaseProvider, getArticleDetailUseCaseProvider);
  }

  public static WikiViewModel newInstance(GetWikiCategoriesUseCase getWikiCategoriesUseCase,
      GetArticlesByCategoryUseCase getArticlesByCategoryUseCase,
      GetArticleDetailUseCase getArticleDetailUseCase) {
    return new WikiViewModel(getWikiCategoriesUseCase, getArticlesByCategoryUseCase, getArticleDetailUseCase);
  }
}
