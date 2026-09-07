package com.example.teamties.feature.auth.presentation.mapper;

import com.example.teamties.core.essentials.resources.StringProviderStore;
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
public final class AuthErrorMapper_Factory implements Factory<AuthErrorMapper> {
  private final Provider<StringProviderStore> stringProviderStoreProvider;

  private AuthErrorMapper_Factory(Provider<StringProviderStore> stringProviderStoreProvider) {
    this.stringProviderStoreProvider = stringProviderStoreProvider;
  }

  @Override
  public AuthErrorMapper get() {
    return newInstance(stringProviderStoreProvider.get());
  }

  public static AuthErrorMapper_Factory create(
      Provider<StringProviderStore> stringProviderStoreProvider) {
    return new AuthErrorMapper_Factory(stringProviderStoreProvider);
  }

  public static AuthErrorMapper newInstance(StringProviderStore stringProviderStore) {
    return new AuthErrorMapper(stringProviderStore);
  }
}
