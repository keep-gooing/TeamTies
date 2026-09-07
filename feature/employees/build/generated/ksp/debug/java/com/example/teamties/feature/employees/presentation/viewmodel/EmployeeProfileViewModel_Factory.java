package com.example.teamties.feature.employees.presentation.viewmodel;

import androidx.lifecycle.SavedStateHandle;
import com.example.teamties.feature.employees.domain.usecase.GetEmployeeByIdUseCase;
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
public final class EmployeeProfileViewModel_Factory implements Factory<EmployeeProfileViewModel> {
  private final Provider<GetEmployeeByIdUseCase> getEmployeeByIdUseCaseProvider;

  private final Provider<SavedStateHandle> savedStateHandleProvider;

  private EmployeeProfileViewModel_Factory(
      Provider<GetEmployeeByIdUseCase> getEmployeeByIdUseCaseProvider,
      Provider<SavedStateHandle> savedStateHandleProvider) {
    this.getEmployeeByIdUseCaseProvider = getEmployeeByIdUseCaseProvider;
    this.savedStateHandleProvider = savedStateHandleProvider;
  }

  @Override
  public EmployeeProfileViewModel get() {
    return newInstance(getEmployeeByIdUseCaseProvider.get(), savedStateHandleProvider.get());
  }

  public static EmployeeProfileViewModel_Factory create(
      Provider<GetEmployeeByIdUseCase> getEmployeeByIdUseCaseProvider,
      Provider<SavedStateHandle> savedStateHandleProvider) {
    return new EmployeeProfileViewModel_Factory(getEmployeeByIdUseCaseProvider, savedStateHandleProvider);
  }

  public static EmployeeProfileViewModel newInstance(GetEmployeeByIdUseCase getEmployeeByIdUseCase,
      SavedStateHandle savedStateHandle) {
    return new EmployeeProfileViewModel(getEmployeeByIdUseCase, savedStateHandle);
  }
}
