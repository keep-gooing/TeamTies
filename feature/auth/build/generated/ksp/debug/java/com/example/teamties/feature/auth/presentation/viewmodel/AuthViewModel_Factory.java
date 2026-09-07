package com.example.teamties.feature.auth.presentation.viewmodel;

import com.example.teamties.feature.auth.domain.usecase.CheckSessionUseCase;
import com.example.teamties.feature.auth.domain.usecase.LoginUseCase;
import com.example.teamties.feature.auth.domain.usecase.LogoutUseCase;
import com.example.teamties.feature.auth.presentation.mapper.AuthErrorMapper;
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
public final class AuthViewModel_Factory implements Factory<AuthViewModel> {
  private final Provider<LoginUseCase> loginUseCaseProvider;

  private final Provider<LogoutUseCase> logoutUseCaseProvider;

  private final Provider<CheckSessionUseCase> checkSessionUseCaseProvider;

  private final Provider<AuthErrorMapper> authErrorMapperProvider;

  private AuthViewModel_Factory(Provider<LoginUseCase> loginUseCaseProvider,
      Provider<LogoutUseCase> logoutUseCaseProvider,
      Provider<CheckSessionUseCase> checkSessionUseCaseProvider,
      Provider<AuthErrorMapper> authErrorMapperProvider) {
    this.loginUseCaseProvider = loginUseCaseProvider;
    this.logoutUseCaseProvider = logoutUseCaseProvider;
    this.checkSessionUseCaseProvider = checkSessionUseCaseProvider;
    this.authErrorMapperProvider = authErrorMapperProvider;
  }

  @Override
  public AuthViewModel get() {
    return newInstance(loginUseCaseProvider.get(), logoutUseCaseProvider.get(), checkSessionUseCaseProvider.get(), authErrorMapperProvider.get());
  }

  public static AuthViewModel_Factory create(Provider<LoginUseCase> loginUseCaseProvider,
      Provider<LogoutUseCase> logoutUseCaseProvider,
      Provider<CheckSessionUseCase> checkSessionUseCaseProvider,
      Provider<AuthErrorMapper> authErrorMapperProvider) {
    return new AuthViewModel_Factory(loginUseCaseProvider, logoutUseCaseProvider, checkSessionUseCaseProvider, authErrorMapperProvider);
  }

  public static AuthViewModel newInstance(LoginUseCase loginUseCase, LogoutUseCase logoutUseCase,
      CheckSessionUseCase checkSessionUseCase, AuthErrorMapper authErrorMapper) {
    return new AuthViewModel(loginUseCase, logoutUseCase, checkSessionUseCase, authErrorMapper);
  }
}
