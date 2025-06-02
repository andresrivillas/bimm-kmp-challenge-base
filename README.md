Mobile Developer Challenge (iOS & Android)

This project is a cross-platform mobile application developed as a technical challenge, demonstrating the use of Kotlin Multiplatform (KMP) for sharing business logic and models across iOS and Android.

📱 Platforms

iOS: Built with Swift and SwiftUI.
Android: Built with Kotlin and Jetpack Compose.
🔗 Shared Code

The data layer is shared across platforms using Kotlin Multiplatform and includes:

Data Transfer Objects (DTOs)
Repository logic
JSON parsing and service simulation
🧪 Testing

Each ViewModel is tested using its native platform technology:
Swift (XCTest) for iOS ViewModels
Kotlin (JUnit) for Android ViewModels
This allows better integration with platform-specific tools and IDE features.

📦 JSON Handling

Instead of using real network calls, the app reads a local JSON string to simulate API responses.
DTOs are structured to support error handling, though error logic is not implemented for simplicity.
📐 Architecture Overview

KMP Shared Module contains reusable business logic and models.
Native UI Layers manage navigation, presentation, and rendering using their respective technologies.
🚧 Known Simplifications

DTOs include error structures, but error handling is not active.
The service reads JSON from local strings to avoid external dependencies and keep the setup lightweight.
🚀 Purpose

This project demonstrates:

Clean architecture with separation of concerns
Efficient use of Kotlin Multiplatform
Native development best practices for iOS and Android
Testable, modular code structure