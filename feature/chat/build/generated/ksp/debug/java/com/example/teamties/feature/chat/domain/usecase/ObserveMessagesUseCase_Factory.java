package com.example.teamties.feature.chat.domain.usecase;

import com.example.teamties.feature.chat.domain.repository.ChatRepository;
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
public final class ObserveMessagesUseCase_Factory implements Factory<ObserveMessagesUseCase> {
  private final Provider<ChatRepository> repositoryProvider;

  private ObserveMessagesUseCase_Factory(Provider<ChatRepository> repositoryProvider) {
    this.repositoryProvider = repositoryProvider;
  }

  @Override
  public ObserveMessagesUseCase get() {
    return newInstance(repositoryProvider.get());
  }

  public static ObserveMessagesUseCase_Factory create(Provider<ChatRepository> repositoryProvider) {
    return new ObserveMessagesUseCase_Factory(repositoryProvider);
  }

  public static ObserveMessagesUseCase newInstance(ChatRepository repository) {
    return new ObserveMessagesUseCase(repository);
  }
}
