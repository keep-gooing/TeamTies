package com.example.teamties.core.essentials.exceptions.handler;

import dagger.internal.DaggerGenerated;
import dagger.internal.Factory;
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
public final class DefaultExceptionHandler_Factory implements Factory<DefaultExceptionHandler> {
  @Override
  public DefaultExceptionHandler get() {
    return newInstance();
  }

  public static DefaultExceptionHandler_Factory create() {
    return InstanceHolder.INSTANCE;
  }

  public static DefaultExceptionHandler newInstance() {
    return new DefaultExceptionHandler();
  }

  private static final class InstanceHolder {
    static final DefaultExceptionHandler_Factory INSTANCE = new DefaultExceptionHandler_Factory();
  }
}
