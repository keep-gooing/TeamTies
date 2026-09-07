package com.example.teamties.feature.wiki.data.repository;

import dagger.internal.DaggerGenerated;
import dagger.internal.Factory;
import dagger.internal.QualifierMetadata;
import dagger.internal.ScopeMetadata;
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
public final class FakeWikiRepositoryImpl_Factory implements Factory<FakeWikiRepositoryImpl> {
  @Override
  public FakeWikiRepositoryImpl get() {
    return newInstance();
  }

  public static FakeWikiRepositoryImpl_Factory create() {
    return InstanceHolder.INSTANCE;
  }

  public static FakeWikiRepositoryImpl newInstance() {
    return new FakeWikiRepositoryImpl();
  }

  private static final class InstanceHolder {
    static final FakeWikiRepositoryImpl_Factory INSTANCE = new FakeWikiRepositoryImpl_Factory();
  }
}
