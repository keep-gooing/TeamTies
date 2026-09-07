package com.example.teamties.feature.auth.domain.usecase;

import com.example.teamties.feature.auth.domain.repository.AuthRepository;
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
public final class LoginUseCase_Factory implements Factory<LoginUseCase> {
  private final Provider<AuthRepository> repositoryProvider;

  private LoginUseCase_Factory(Provider<AuthRepository> repositoryProvider) {
    this.repositoryProvider = repositoryProvider;
  }

  @Override
  public LoginUseCase get() {
    return newInstance(repositoryProvider.get());
  }

  public static LoginUseCase_Factory create(Provider<AuthRepository> repositoryProvider) {
    return new LoginUseCase_Factory(repositoryProvider);
  }

  public static LoginUseCase newInstance(AuthRepository repository) {
    return new LoginUseCase(repository);
  }
}
