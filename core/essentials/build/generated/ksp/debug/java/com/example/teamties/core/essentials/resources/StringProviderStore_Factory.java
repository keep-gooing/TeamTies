package com.example.teamties.core.essentials.resources;

import dagger.internal.DaggerGenerated;
import dagger.internal.Factory;
import dagger.internal.Provider;
import dagger.internal.QualifierMetadata;
import dagger.internal.ScopeMetadata;
import java.util.Map;
import javax.annotation.processing.Generated;

@ScopeMetadata("javax.inject.Singleton")
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
public final class StringProviderStore_Factory implements Factory<StringProviderStore> {
  private final Provider<Map<Class<?>, StringProvider>> stringProvidersProvider;

  private StringProviderStore_Factory(
      Provider<Map<Class<?>, StringProvider>> stringProvidersProvider) {
    this.stringProvidersProvider = stringProvidersProvider;
  }

  @Override
  public StringProviderStore get() {
    return newInstance(stringProvidersProvider.get());
  }

  public static StringProviderStore_Factory create(
      Provider<Map<Class<?>, StringProvider>> stringProvidersProvider) {
    return new StringProviderStore_Factory(stringProvidersProvider);
  }

  public static StringProviderStore newInstance(Map<Class<?>, StringProvider> stringProviders) {
    return new StringProviderStore(stringProviders);
  }
}
