package com.example.teamties.core.essentials.exceptions.mapper;

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
public final class DefaultExceptionToMessageMapper_Factory implements Factory<DefaultExceptionToMessageMapper> {
  private final Provider<StringProviderStore> stringProviderStoreProvider;

  private DefaultExceptionToMessageMapper_Factory(
      Provider<StringProviderStore> stringProviderStoreProvider) {
    this.stringProviderStoreProvider = stringProviderStoreProvider;
  }

  @Override
  public DefaultExceptionToMessageMapper get() {
    return newInstance(stringProviderStoreProvider.get());
  }

  public static DefaultExceptionToMessageMapper_Factory create(
      Provider<StringProviderStore> stringProviderStoreProvider) {
    return new DefaultExceptionToMessageMapper_Factory(stringProviderStoreProvider);
  }

  public static DefaultExceptionToMessageMapper newInstance(
      StringProviderStore stringProviderStore) {
    return new DefaultExceptionToMessageMapper(stringProviderStore);
  }
}
