package com.example.teamties.feature.employees.data.repository;

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
public final class FakeEmployeeRepositoryImpl_Factory implements Factory<FakeEmployeeRepositoryImpl> {
  @Override
  public FakeEmployeeRepositoryImpl get() {
    return newInstance();
  }

  public static FakeEmployeeRepositoryImpl_Factory create() {
    return InstanceHolder.INSTANCE;
  }

  public static FakeEmployeeRepositoryImpl newInstance() {
    return new FakeEmployeeRepositoryImpl();
  }

  private static final class InstanceHolder {
    static final FakeEmployeeRepositoryImpl_Factory INSTANCE = new FakeEmployeeRepositoryImpl_Factory();
  }
}
