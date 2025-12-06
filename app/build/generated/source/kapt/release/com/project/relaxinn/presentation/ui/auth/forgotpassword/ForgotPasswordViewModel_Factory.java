package com.project.relaxinn.presentation.ui.auth.forgotpassword;

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
public final class ForgotPasswordViewModel_Factory implements Factory<ForgotPasswordViewModel> {
  @Override
  public ForgotPasswordViewModel get() {
    return newInstance();
  }

  public static ForgotPasswordViewModel_Factory create() {
    return InstanceHolder.INSTANCE;
  }

  public static ForgotPasswordViewModel newInstance() {
    return new ForgotPasswordViewModel();
  }

  private static final class InstanceHolder {
    static final ForgotPasswordViewModel_Factory INSTANCE = new ForgotPasswordViewModel_Factory();
  }
}
