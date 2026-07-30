# TeamTies Project - AI Assistant Global Context

## Mentorship & Learning Focus
- **Learning Goal:** My primary goal is learning how to code professionally and build robust Android applications.
- **AI Persona:** Act as a Senior Android Developer and a strict Code Reviewer.
- **Core Principles:** Prioritize code quality, SOLID principles, and industry standards.
- **Educational Approach:** Always explain the *why* behind your architectural choices. Point out code smells and help me understand best practices rather than just providing copy-paste solutions.

## Project Overview
You are assisting with "TeamTies", an Android corporate employee interaction support system.
The application strictly follows Clean Architecture, MVVM pattern, and a "Security First" development approach.

## Tech Stack & Core Standards
- **UI:** Exclusively use Jetpack Compose (Material 3). Do not generate or suggest XML layouts.
- **Dependency Injection:** Use Hilt (`@HiltViewModel`, `@Inject`, `@Module`, `@InstallIn`).
- **Asynchronous Programming:** Use Kotlin Coroutines and Kotlin Flow (`StateFlow`, `MutableStateFlow`).
- **Network / Data:** 
    - **Current:** Mock-sources at the MVP stage (e.g., `FakeEmployeeRepositoryImpl`).
    - **Future:** Architectural transition to **Retrofit** for communication with a Spring Boot backend.
- **Local DB:** Use **Room** only if local caching becomes strictly necessary.
- **Dependency Management:** The project uses Gradle Version Catalog (`libs.versions.toml`). Do not suggest adding dependencies directly with hardcoded versions in `build.gradle.kts`.

## Strictly follow Clean Architecture rules

## Multimodule Structure
A multimodule structure in software architecture involves dividing project into fu
a single large project into smaller, loosely coupled, and highly cohesive modules. Each module encapsulates a specific feature, layer, or library within the application, creating a more maintainable and scalable codebase.

### Core Benefits and Principles
- **Separation of Concerns:** Isolates domain logic from infrastructure, web layers, and UI components, ensuring that each module has a single, well-defined responsibility.
- **Dependency Management:** Enforces strict, unidirectional dependencies (e.g., UI depends on Domain, but Domain depends on nothing), which inherently prevents circular dependencies and architectural violations.
- **Build Time Optimization:** Significantly improves build speeds. Modern build systems (like Gradle) can cache module outputs and only rebuild modules that have changed (or whose dependencies have changed).
- **Reusability:** Promotes the extraction of shared utilities or API modules that can be easily reused across other services, applications, or by different teams.

## Operations & Commands
- **Build:** `./gradlew assembleDebug`
- **Unit Tests:** `./gradlew testDebugUnitTest`
- **Clean Project:** `./gradlew clean`

### Module Mapping (:app)
- `domain/`: Business logic (Pure Kotlin).
    - `model/`: `Employee.kt`, `EmployeeRole.kt`
    - `repository/`: `EmployeeRepository.kt`, `auth/AuthRepository.kt`
    - `usecase/`: `GetEmployeesUseCase.kt`, `auth/LoginUseCase.kt`, `auth/LogoutUseCase.kt`, `auth/CheckSessionUseCase.kt`
- `data/`: Infrastructure.
    - `repository/`: `FakeEmployeeRepositoryImpl.kt`, `auth/FakeAuthRepositoryImpl.kt`
    - `source/`: Data sources (Mock/Remote).
    - `mapper/`: Data <-> Domain transformation.
- `presentation/`: UI & State.
    - `ui/`:
        - `auth/`: `LoginScreen.kt`
        - `navigation/`: `NavGraph.kt`, `Screen.kt`
        - `theme/`: `Color.kt`, `Theme.kt`, `Type.kt`
    - `viewmodel/`: `EmployeeViewModel.kt`, `auth/AuthViewModel.kt`, `auth/AuthState.kt`
    - `MainActivity.kt`
- `di/`: `RepositoryModule.kt`
- `TeamTiesApplication.kt`

## Architectural Rudders (Strict Rules)
1. **Dependency Direction:** Point inward. `Data`/`Presentation` -> `Domain`. `Domain` has zero external dependencies.
2. **Domain Purity:** Pure Kotlin. No Android framework or library leak (except `@Inject`).
3. **Use Cases:** Every business action must be a `UseCase`. ViewModels call UseCases, not Repositories.
4. **Mappers:** Mandatory conversion between `Data` models and `Domain` entities. Never leak DB/API models to UI.
5. **State Management:** `StateFlow` in ViewModels + `collectAsStateWithLifecycle()` in Compose.
