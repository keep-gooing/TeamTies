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
public final class GetWikiCategoriesUseCase_Factory implements Factory<GetWikiCategoriesUseCase> {
  private final Provider<WikiRepository> repositoryProvider;

  private GetWikiCategoriesUseCase_Factory(Provider<WikiRepository> repositoryProvider) {
    this.repositoryProvider = repositoryProvider;
  }

  @Override
  public GetWikiCategoriesUseCase get() {
    return newInstance(repositoryProvider.get());
  }

  public static GetWikiCategoriesUseCase_Factory create(
      Provider<WikiRepository> repositoryProvider) {
    return new GetWikiCategoriesUseCase_Factory(repositoryProvider);
  }

  public static GetWikiCategoriesUseCase newInstance(WikiRepository repository) {
    return new GetWikiCategoriesUseCase(repository);
  }
}
