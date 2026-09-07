package com.example.teamties.feature.chat.presentation.viewmodel;

import androidx.lifecycle.SavedStateHandle;
import com.example.teamties.feature.chat.domain.usecase.GetChannelsUseCase;
import com.example.teamties.feature.chat.domain.usecase.ObserveMessagesUseCase;
import com.example.teamties.feature.chat.domain.usecase.SendMessageUseCase;
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
public final class ChatViewModel_Factory implements Factory<ChatViewModel> {
  private final Provider<GetChannelsUseCase> getChannelsUseCaseProvider;

  private final Provider<ObserveMessagesUseCase> observeMessagesUseCaseProvider;

  private final Provider<SendMessageUseCase> sendMessageUseCaseProvider;

  private final Provider<SavedStateHandle> savedStateHandleProvider;

  private ChatViewModel_Factory(Provider<GetChannelsUseCase> getChannelsUseCaseProvider,
      Provider<ObserveMessagesUseCase> observeMessagesUseCaseProvider,
      Provider<SendMessageUseCase> sendMessageUseCaseProvider,
      Provider<SavedStateHandle> savedStateHandleProvider) {
    this.getChannelsUseCaseProvider = getChannelsUseCaseProvider;
    this.observeMessagesUseCaseProvider = observeMessagesUseCaseProvider;
    this.sendMessageUseCaseProvider = sendMessageUseCaseProvider;
    this.savedStateHandleProvider = savedStateHandleProvider;
  }

  @Override
  public ChatViewModel get() {
    return newInstance(getChannelsUseCaseProvider.get(), observeMessagesUseCaseProvider.get(), sendMessageUseCaseProvider.get(), savedStateHandleProvider.get());
  }

  public static ChatViewModel_Factory create(
      Provider<GetChannelsUseCase> getChannelsUseCaseProvider,
      Provider<ObserveMessagesUseCase> observeMessagesUseCaseProvider,
      Provider<SendMessageUseCase> sendMessageUseCaseProvider,
      Provider<SavedStateHandle> savedStateHandleProvider) {
    return new ChatViewModel_Factory(getChannelsUseCaseProvider, observeMessagesUseCaseProvider, sendMessageUseCaseProvider, savedStateHandleProvider);
  }

  public static ChatViewModel newInstance(GetChannelsUseCase getChannelsUseCase,
      ObserveMessagesUseCase observeMessagesUseCase, SendMessageUseCase sendMessageUseCase,
      SavedStateHandle savedStateHandle) {
    return new ChatViewModel(getChannelsUseCase, observeMessagesUseCase, sendMessageUseCase, savedStateHandle);
  }
}
