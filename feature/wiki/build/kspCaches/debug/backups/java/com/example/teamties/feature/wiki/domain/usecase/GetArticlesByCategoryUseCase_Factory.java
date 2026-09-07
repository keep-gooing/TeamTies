package com.example.teamties.feature.wiki.domain.usecase;

import com.example.teamties.feature.wiki.domain.repository.WikiRepository;
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
public final class GetArticlesByCategoryUseCase_Factory implements Factory<GetArticlesByCategoryUseCase> {
  private final Provider<WikiRepository> repositoryProvider;

  private GetArticlesByCategoryUseCase_Factory(Provider<WikiRepository> repositoryProvider) {
    this.repositoryProvider = repositoryProvider;
  }

  @Override
  public GetArticlesByCategoryUseCase get() {
    return newInstance(repositoryProvider.get());
  }

  public static GetArticlesByCategoryUseCase_Factory create(
      Provider<WikiRepository> repositoryProvider) {
    return new GetArticlesByCategoryUseCase_Factory(repositoryProvider);
  }

  public static GetArticlesByCategoryUseCase newInstance(WikiRepository repository) {
    return new GetArticlesByCategoryUseCase(repository);
  }
}
