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
public final class GetArticleDetailUseCase_Factory implements Factory<GetArticleDetailUseCase> {
  private final Provider<WikiRepository> repositoryProvider;

  private GetArticleDetailUseCase_Factory(Provider<WikiRepository> repositoryProvider) {
    this.repositoryProvider = repositoryProvider;
  }

  @Override
  public GetArticleDetailUseCase get() {
    return newInstance(repositoryProvider.get());
  }

  public static GetArticleDetailUseCase_Factory create(
      Provider<WikiRepository> repositoryProvider) {
    return new GetArticleDetailUseCase_Factory(repositoryProvider);
  }

  public static GetArticleDetailUseCase newInstance(WikiRepository repository) {
    return new GetArticleDetailUseCase(repository);
  }
}
