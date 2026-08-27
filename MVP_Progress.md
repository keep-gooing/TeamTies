# TeamTies MVP - Progress Tracker

**Architecture:** Android Clean Architecture (Domain, Data, Presentation)
**Tech Stack:** Jetpack Compose, Hilt, Coroutines/Flow, Room (if needed), EncryptedSharedPreferences

---

## Phase 1: Project Foundation & Security Setup
- [x] **1.1 Dependency & Build Setup**
    - [x] Configure `libs.versions.toml` (Version Catalog) for all dependencies.
    - [x] Setup Hilt for Dependency Injection (`@HiltAndroidApp`, base modules).
    - [x] Configure base package structure (`com.example.teamties.domain`, `.data`, `.presentation`).

## Phase 2: Authentication & Session Management
- [x] **2.1 Domain Layer**
    - [x] Create `AuthRepository` interface.
    - [x] Implement `LoginUseCase`, `LogoutUseCase`, `CheckSessionUseCase`.
    - [x] Define PBAC (Permission-Based Access Control) domain entities (e.g., `AppPermission` enum).
- [x] **2.2 Data Layer**
    - [x] Implement `FakeAuthRepositoryImpl` (mocking JWT and roles for MVP).
- [x] **2.3 Presentation Layer**
    - [x] Build `LoginScreen` using Jetpack Compose.
    - [x] Implement `AuthViewModel` with `StateFlow` to handle loading, success, and error states.

## Phase 3: Employee Directory & Profiles
- [x] **3.1 Domain Layer**
    - [x] Define `Employee` entity.
    - [x] Implement `GetEmployeesUseCase` and `SearchEmployeesUseCase` (with debounce logic).
- [x] **3.2 Data Layer**
    - [x] Implement `FakeEmployeeRepositoryImpl` with mock corporate data.
- [x] **3.3 Presentation Layer**
    - [x] Build `DirectoryScreen` with `LazyColumn` for scalable lists.
    - [x] Implement reactive search bar using `MutableStateFlow` and `.debounce()`.
    - [x] Build `EmployeeProfileScreen` displaying details and secure avatar loading (Coil).
    - [x] Implement secure Android Intents for quick contact (Email/Phone).

## Phase 4: Real-Time Team Channels & Direct Messaging
- [x] **4.1 Domain Layer**
    - [x] Define `Message`, `Channel`, and `ChatSession` entities.
    - [x] Implement `GetChannelsUseCase`, `SendMessageUseCase`, `ObserveMessagesUseCase`.
- [] **4.2 Data Layer**
    - [] Implement `FakeChatRepositoryImpl` (mocking WebSocket flow behavior with Kotlin `SharedFlow`/`Channel`).
- [] **4.3 Presentation Layer**
    - [] Build `ChannelListScreen` showing active conversations.
    - [] Build `ChatScreen` capable of real-time UI updates upon new message flows.

## Phase 5: Knowledge Base (Corporate Wiki)
- [x] **5.1 Domain Layer**
    - [x] Define `WikiArticle` and `WikiCategory` entities.
    - [x] Implement `GetWikiCategoriesUseCase` and `GetArticleDetailUseCase`.
- [x] **5.2 Data Layer**
    - [x] Implement `FakeWikiRepositoryImpl`.
- [x] **5.3 Presentation Layer**
    - [x] Build `WikiHomeScreen` with category navigation.
    - [x] Build `ArticleScreen` with rich-text display capabilities.

## Phase 6: Joint Initiative / Project Spaces
- [ ] **6.1 Domain Layer**
    - [ ] Define `Initiative`, `Task`, and `TaskStatus` entities.
    - [ ] Implement `GetInitiativesUseCase`, `GetTasksForInitiativeUseCase`, and `UpdateTaskStatusUseCase` with strict transition rules.
- [ ] **6.2 Data Layer**
    - [ ] Implement `FakeInitiativeRepositoryImpl`.
- [ ] **6.3 Presentation Layer**
    - [ ] Build `InitiativesDashboardScreen` showing active projects and assigned tasks.
    - [ ] Build `InitiativeDetailScreen` and `TaskDetailScreen`.
    - [ ] Implement PBAC UI checks (Managers see assign UI; Employees see status updates).

## Phase 7: Corporate News Feed
- [ ] **7.1 Domain Layer**
    - [ ] Define `NewsPost` entity.
    - [ ] Implement `GetNewsFeedUseCase` and `AcknowledgeNewsUseCase`.
- [ ] **7.2 Data Layer**
    - [ ] Implement `FakeNewsRepositoryImpl`.
- [ ] **7.3 Presentation Layer**
    - [ ] Build `NewsFeedScreen` with Pull-to-Refresh capabilities.
    - [ ] Build `NewsDetailScreen` for full content viewing.
    - [ ] Implement UI for the \"Acknowledge/Read\" action with atomic state updates.

## Phase 8: Administration (MVP Scoping)
- [ ] **8.1 Domain & Presentation**
    - [ ] Implement basic Admin Dashboard UI (hidden via RBAC for non-admins).
    - [ ] Add `MockOffboardEmployeeUseCase` to demonstrate instant access revocation.
