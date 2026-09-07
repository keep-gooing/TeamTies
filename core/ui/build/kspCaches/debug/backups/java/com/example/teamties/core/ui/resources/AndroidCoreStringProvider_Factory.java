package com.example.teamties.core.ui.resources;

import android.content.Context;
import dagger.internal.DaggerGenerated;
import dagger.internal.Factory;
import dagger.internal.Provider;
import dagger.internal.QualifierMetadata;
import dagger.internal.ScopeMetadata;
import javax.annotation.processing.Generated;

@ScopeMetadata("javax.inject.Singleton")
@QualifierMetadata("dagger.hilt.android.qualifiers.ApplicationContext")
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
public final class AndroidCoreStringProvider_Factory implements Factory<AndroidCoreStringProvider> {
  private final Provider<Context> contextProvider;

  private AndroidCoreStringProvider_Factory(Provider<Context> contextProvider) {
    this.contextProvider = contextProvider;
  }

  @Override
  public AndroidCoreStringProvider get() {
    return newInstance(contextProvider.get());
  }

  public static AndroidCoreStringProvider_Factory create(Provider<Context> contextProvider) {
    return new AndroidCoreStringProvider_Factory(contextProvider);
  }

  public static AndroidCoreStringProvider newInstance(Context context) {
    return new AndroidCoreStringProvider(context);
  }
}
