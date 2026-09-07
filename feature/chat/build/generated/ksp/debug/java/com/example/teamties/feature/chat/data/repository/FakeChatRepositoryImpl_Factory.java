package com.example.teamties.feature.chat.data.repository;

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
public final class FakeChatRepositoryImpl_Factory implements Factory<FakeChatRepositoryImpl> {
  @Override
  public FakeChatRepositoryImpl get() {
    return newInstance();
  }

  public static FakeChatRepositoryImpl_Factory create() {
    return InstanceHolder.INSTANCE;
  }

  public static FakeChatRepositoryImpl newInstance() {
    return new FakeChatRepositoryImpl();
  }

  private static final class InstanceHolder {
    static final FakeChatRepositoryImpl_Factory INSTANCE = new FakeChatRepositoryImpl_Factory();
  }
}
