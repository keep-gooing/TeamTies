# TeamTies MVP - Functional Requirements
*Information System for Supporting Corporate Employee Interaction*

**Technical Foundation:** The TeamTies application is strictly built on Android Clean Architecture principles, utilizing Jetpack Compose for the presentation layer, Hilt for Dependency Injection, and Kotlin Coroutines/Flow for asynchronous data streams. The core philosophy driving all modules is a **"Security First"** approach.

## Authentication & Security
- **Secure User Login:** Employees authenticate using corporate credentials. The system employs secure, encrypted communication (HTTPS/TLS) and validates JWT tokens. The UI relies on Jetpack Compose state management to ensure sensitive input is handled securely.
- **Session Management:** Secure, encrypted token storage implemented exclusively via `EncryptedSharedPreferences` (or `DataStore` with security wrappers). The application enforces automatic, proactive logout upon session expiration or detected unauthorized environment anomalies.
- **Role-based Access (RBAC):** Strict domain-level validation of permissions (e.g., Employee, Manager, Admin). The Jetpack Compose UI dynamically and securely adapts available components and navigation routes based on the verified role, preventing unauthorized access to restricted features.
- **Data Protection Measures:** Implementation of `FLAG_SECURE` at the activity level to prevent screen recording and screenshots on sensitive screens, alongside secure clipboard management for sensitive data fields.

## Employee Profile & Directory
- **Comprehensive Employee Profile:** Displays verified employee data including First/Last name, position, department, contact info, and securely cached avatar images. Data is fetched via decoupled Domain UseCases.
- **Directory List:** A scalable, searchable list of all company employees. Implemented in the presentation layer using Compose `LazyColumn` integrated with reactive data streams (`StateFlow`) to handle large corporate directories efficiently without blocking the main thread.
- **Search & Filtering:** Real-time, reactive search capabilities. Search queries are debounced using Kotlin Coroutines to optimize network/database load while filtering by name, role, or department.
- **Hierarchy View:** Quick access to organizational charts displaying an employee's direct reporting line (managers and subordinates), resolved through data layer repositories.
- **Quick Contact:** Direct, secure action intents to initiate phone calls, emails, or internal messaging directly from the profile card, ensuring no data leakage during intent handoff.

## Real-Time Team Channels & Direct Messaging
- **Persistent Channels:** Chat rooms for departments, initiatives, or projects. Handled via WebSocket connections for real-time delivery with Coroutines (`Flow` / `Channel`) efficiently managing the asynchronous event stream on the client.
- **Direct Messaging:** Secure 1-on-1 communication between employees.
- **Message State & Persistence:** Unread notifications and message history persistence. In the MVP, this relies on decoupled repositories that handle message syncing and caching.

## Knowledge Base (Corporate Wiki)
- **Centralized Documentation:** Rich-text view of corporate articles, HR policies, and technical documentation.
- **Hierarchical Navigation:** Organized by Spaces/Folders or tags. State is managed via Compose and loaded asynchronously.
- **Role-Based Viewing:** Securely restricted documentation based on the user's RBAC role (e.g., specific departments can only view specific spaces).

## Joint Initiative / Project Spaces
- **Dedicated Workspaces:** Spaces where users can define a goal, add members, and create actionable to-do lists for cross-functional collaboration.
- **Task & Status Tracking:** Employees can transition task states (e.g., *To Do* ➔ *In Progress* ➔ *Under Review* ➔ *Done*). State transitions are governed by strict Domain rules to prevent invalid lifecycle jumps.
- **Personal Dashboard:** A reactive, state-driven screen (`StateFlow` collected in Compose) displaying assigned tasks across all initiatives, sorted by priority, deadline, or status.
- **Manager View:** Authorized managers can assign tasks, monitor project progress, and reassign tasks. Data is aggregated securely based on RBAC permissions.

## Corporate News Feed
- **Global Feed:** A centralized, reactive timeline displaying company-wide announcements. Supports efficient pull-to-refresh mechanisms backed by Coroutine-driven network synchronization.
- **Rich Post Details:** Expanding a news item allows reading full content and viewing attached media. Media is loaded and cached securely using modern image loading libraries (e.g., Coil).
- **Basic Engagement:** Employees can acknowledge important news (e.g., "Read/Understood"). These actions trigger atomic, idempotent network requests to guarantee consistency.

## Administration
- **Secure Onboarding/Offboarding:** Admin capability to invite new employees or instantly revoke access and invalidate tokens for offboarded employees, mitigating security risks.
- **Content Moderation:** Authorized roles (Admins/HR) can securely publish, edit, or delete posts in the Corporate News Feed and Knowledge Base with full audit logging capabilities on the backend.

## Happy case of using the service
**Daily Employee Routine:**
1. An employee opens the **TeamTies** Android app.
2. The app enforces the "Security First" protocol, verifying the active encrypted session (prompting for biometric re-authentication or silently refreshing the token securely).
3. Upon successful validation, the Compose UI reactively renders the **Corporate News Feed**. The employee views a new announcement regarding Q3 objectives and taps "Acknowledge", triggering a secure background update via Coroutines.
4. The employee navigates to the **Joint Initiatives** dashboard. They review today's assignments across their projects, select an urgent item, and update its state to "In Progress".
5. Needing clarification on a procedure, the employee consults the **Knowledge Base**, easily finding the relevant technical documentation.
6. To discuss the findings, they open the **Team Channels & Direct Messaging** to instantly message the Project Lead via WebSockets.
7. Later, they utilize the debounced search in the **Employee Directory** to quickly find a new colleague, view their profile, and tap the email icon to securely launch the mail client.