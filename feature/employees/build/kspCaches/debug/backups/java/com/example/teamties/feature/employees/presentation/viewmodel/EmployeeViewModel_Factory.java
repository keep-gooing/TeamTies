package com.example.teamties.feature.employees.presentation.viewmodel;

import com.example.teamties.feature.employees.domain.usecase.GetEmployeesUseCase;
import com.example.teamties.feature.employees.domain.usecase.SearchEmployeesUseCase;
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
public final class EmployeeViewModel_Factory implements Factory<EmployeeViewModel> {
  private final Provider<GetEmployeesUseCase> getEmployeesUseCaseProvider;

  private final Provider<SearchEmployeesUseCase> searchEmployeesUseCaseProvider;

  private EmployeeViewModel_Factory(Provider<GetEmployeesUseCase> getEmployeesUseCaseProvider,
      Provider<SearchEmployeesUseCase> searchEmployeesUseCaseProvider) {
    this.getEmployeesUseCaseProvider = getEmployeesUseCaseProvider;
    this.searchEmployeesUseCaseProvider = searchEmployeesUseCaseProvider;
  }

  @Override
  public EmployeeViewModel get() {
    return newInstance(getEmployeesUseCaseProvider.get(), searchEmployeesUseCaseProvider.get());
  }

  public static EmployeeViewModel_Factory create(
      Provider<GetEmployeesUseCase> getEmployeesUseCaseProvider,
      Provider<SearchEmployeesUseCase> searchEmployeesUseCaseProvider) {
    return new EmployeeViewModel_Factory(getEmployeesUseCaseProvider, searchEmployeesUseCaseProvider);
  }

  public static EmployeeViewModel newInstance(GetEmployeesUseCase getEmployeesUseCase,
      SearchEmployeesUseCase searchEmployeesUseCase) {
    return new EmployeeViewModel(getEmployeesUseCase, searchEmployeesUseCase);
  }
}
