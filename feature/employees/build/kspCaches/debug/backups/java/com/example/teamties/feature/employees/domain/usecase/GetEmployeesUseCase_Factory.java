package com.example.teamties.feature.employees.domain.usecase;

import com.example.teamties.feature.employees.domain.repository.EmployeeRepository;
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
public final class GetEmployeesUseCase_Factory implements Factory<GetEmployeesUseCase> {
  private final Provider<EmployeeRepository> repositoryProvider;

  private GetEmployeesUseCase_Factory(Provider<EmployeeRepository> repositoryProvider) {
    this.repositoryProvider = repositoryProvider;
  }

  @Override
  public GetEmployeesUseCase get() {
    return newInstance(repositoryProvider.get());
  }

  public static GetEmployeesUseCase_Factory create(
      Provider<EmployeeRepository> repositoryProvider) {
    return new GetEmployeesUseCase_Factory(repositoryProvider);
  }

  public static GetEmployeesUseCase newInstance(EmployeeRepository repository) {
    return new GetEmployeesUseCase(repository);
  }
}
