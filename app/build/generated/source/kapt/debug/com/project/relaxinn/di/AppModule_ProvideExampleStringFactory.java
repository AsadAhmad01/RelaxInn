package com.project.relaxinn.di;

import dagger.internal.DaggerGenerated;
import dagger.internal.Factory;
import dagger.internal.Preconditions;
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
public final class AppModule_ProvideExampleStringFactory implements Factory<String> {
  @Override
  public String get() {
    return provideExampleString();
  }

  public static AppModule_ProvideExampleStringFactory create() {
    return InstanceHolder.INSTANCE;
  }

  public static String provideExampleString() {
    return Preconditions.checkNotNullFromProvides(AppModule.INSTANCE.provideExampleString());
  }

  private static final class InstanceHolder {
    static final AppModule_ProvideExampleStringFactory INSTANCE = new AppModule_ProvideExampleStringFactory();
  }
}
