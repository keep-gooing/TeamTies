# TeamTies MVP - Progress Tracker

**Architecture:** Android Clean Architecture (Domain, Data, Presentation)
**Tech Stack:** Jetpack Compose, Hilt, Coroutines/Flow, Room (if needed), EncryptedSharedPreferences

---

## Phase 1: Project Foundation & Security Setup
- [ ] **1.1 Dependency & Build Setup**
    - [ ] Configure `libs.versions.toml` (Version Catalog) for all dependencies.
    - [ ] Setup Hilt for Dependency Injection (`@HiltAndroidApp`, base modules).
    - [ ] Configure base package structure (`com.example.teamties.domain`, `.data`, `.presentation`).

## Phase 2: Authentication & Session Management
- [ ] **2.1 Domain Layer**
    - [x] Create `AuthRepository` interface.
    - [ ] Implement `LoginUseCase`, `LogoutUseCase`, `CheckSessionUseCase`.
    - [ ] Define RBAC (Role-Based Access Control) domain entities (e.g., `EmployeeRole` enum).
- [ ] **2.2 Data Layer**
    - [x] Implement `FakeAuthRepositoryImpl` (mocking JWT and roles for MVP).
- [ ] **2.3 Presentation Layer**
    - [x] Build `LoginScreen` using Jetpack Compose.
    - [ ] Implement `AuthViewModel` with `StateFlow` to handle loading, success, and error states.
    - [ ] Implement secure reactive navigation.

## Phase 3: Employee Directory & Profiles
- [ ] **3.1 Domain Layer**
    - [ ] Define `Employee` entity.
    - [ ] Implement `GetEmployeesUseCase` and `SearchEmployeesUseCase` (with debounce logic).
- [ ] **3.2 Data Layer**
    - [ ] Implement `FakeEmployeeRepositoryImpl` with mock corporate data.
- [ ] **3.3 Presentation Layer**
    - [ ] Build `DirectoryScreen` with `LazyColumn` for scalable lists.
    - [ ] Implement reactive search bar using `MutableStateFlow` and `.debounce()`.
    - [ ] Build `EmployeeProfileScreen` displaying details and secure avatar loading (Coil).
    - [ ] Implement secure Android Intents for quick contact (Email/Phone).

## Phase 4: Real-Time Team Channels & Direct Messaging
- [ ] **4.1 Domain Layer**
    - [ ] Define `Message`, `Channel`, and `ChatSession` entities.
    - [ ] Implement `GetChannelsUseCase`, `SendMessageUseCase`, `ObserveMessagesUseCase`.
- [ ] **4.2 Data Layer**
    - [ ] Implement `FakeChatRepositoryImpl` (mocking WebSocket flow behavior with Kotlin `SharedFlow`/`Channel`).
- [ ] **4.3 Presentation Layer**
    - [ ] Build `ChannelListScreen` showing active conversations.
    - [ ] Build `ChatScreen` capable of real-time UI updates upon new message flows.

## Phase 5: Knowledge Base (Corporate Wiki)
- [ ] **5.1 Domain Layer**
    - [ ] Define `WikiArticle` and `WikiCategory` entities.
    - [ ] Implement `GetWikiCategoriesUseCase` and `GetArticleDetailUseCase`.
- [ ] **5.2 Data Layer**
    - [ ] Implement `FakeWikiRepositoryImpl`.
- [ ] **5.3 Presentation Layer**
    - [ ] Build `WikiHomeScreen` with category navigation.
    - [ ] Build `ArticleScreen` with rich-text display capabilities.

## Phase 6: Joint Initiative / Project Spaces
- [ ] **6.1 Domain Layer**
    - [ ] Define `Initiative`, `Task`, and `TaskStatus` entities.
    - [ ] Implement `GetInitiativesUseCase`, `GetTasksForInitiativeUseCase`, and `UpdateTaskStatusUseCase` with strict transition rules.
- [ ] **6.2 Data Layer**
    - [ ] Implement `FakeInitiativeRepositoryImpl`.
- [ ] **6.3 Presentation Layer**
    - [ ] Build `InitiativesDashboardScreen` showing active projects and assigned tasks.
    - [ ] Build `InitiativeDetailScreen` and `TaskDetailScreen`.
    - [ ] Implement RBAC UI checks (Managers see assign UI; Employees see status updates).

## Phase 7: Corporate News Feed
- [ ] **7.1 Domain Layer**
    - [ ] Define `NewsPost` entity.
    - [ ] Implement `GetNewsFeedUseCase` and `AcknowledgeNewsUseCase`.
- [ ] **7.2 Data Layer**
    - [ ] Implement `FakeNewsRepositoryImpl`.
- [ ] **7.3 Presentation Layer**
    - [ ] Build `NewsFeedScreen` with Pull-to-Refresh capabilities.
    - [ ] Build `NewsDetailScreen` for full content viewing.
    - [ ] Implement UI for the "Acknowledge/Read" action with atomic state updates.

## Phase 8: Administration (MVP Scoping)
- [ ] **8.1 Domain & Presentation**
    - [ ] Implement basic Admin Dashboard UI (hidden via RBAC for non-admins).
    - [ ] Add `MockOffboardEmployeeUseCase` to demonstrate instant access revocation.