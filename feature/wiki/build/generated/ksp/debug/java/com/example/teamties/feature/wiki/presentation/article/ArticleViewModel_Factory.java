package com.example.teamties.feature.wiki.presentation.article;

import androidx.lifecycle.SavedStateHandle;
import com.example.teamties.feature.wiki.domain.usecase.GetArticleDetailUseCase;
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
public final class ArticleViewModel_Factory implements Factory<ArticleViewModel> {
  private final Provider<GetArticleDetailUseCase> getArticleDetailUseCaseProvider;

  private final Provider<SavedStateHandle> savedStateHandleProvider;

  private ArticleViewModel_Factory(
      Provider<GetArticleDetailUseCase> getArticleDetailUseCaseProvider,
      Provider<SavedStateHandle> savedStateHandleProvider) {
    this.getArticleDetailUseCaseProvider = getArticleDetailUseCaseProvider;
    this.savedStateHandleProvider = savedStateHandleProvider;
  }

  @Override
  public ArticleViewModel get() {
    return newInstance(getArticleDetailUseCaseProvider.get(), savedStateHandleProvider.get());
  }

  public static ArticleViewModel_Factory create(
      Provider<GetArticleDetailUseCase> getArticleDetailUseCaseProvider,
      Provider<SavedStateHandle> savedStateHandleProvider) {
    return new ArticleViewModel_Factory(getArticleDetailUseCaseProvider, savedStateHandleProvider);
  }

  public static ArticleViewModel newInstance(GetArticleDetailUseCase getArticleDetailUseCase,
      SavedStateHandle savedStateHandle) {
    return new ArticleViewModel(getArticleDetailUseCase, savedStateHandle);
  }
}
