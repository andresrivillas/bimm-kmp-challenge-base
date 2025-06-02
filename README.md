# Mobile Developer Challenge (iOS & Android)

This project is a cross-platform mobile application developed as a technical challenge, demonstrating the use of Kotlin Multiplatform (KMP) for sharing business logic and models across iOS and Android.

## 📱 Platforms
- iOS: Built with Swift and SwiftUI
![App Screenshot](https://imgur.com/9Vc0sHk.jpg)
![App Screenshot](https://imgur.com/jn1SXAp.jpg)
- Android: Built with Kotlin and Jetpack Compose
![App Screenshot](https://imgur.com/aerI5oX.jpg)
![App Screenshot](https://imgur.com/3YQYYR5.jpg)

## 🏗 Architecture
The project follows the Model-View-ViewModel (MVVM) architecture on both platforms:
- Model: Shared via Kotlin Multiplatform
- ViewModel: Platform-specific, using native tools and patterns
- View: Native SwiftUI (iOS) and Jetpack Compose (Android)

## 🔗 Shared Code
The data layer is shared across platforms using Kotlin Multiplatform and includes:
- Data Transfer Objects (DTOs)
- Repository and use case logic
- Service that parses JSON responses

## 🧪 Testing
Each ViewModel is tested using its native platform technology:
- ✅ XCTest for Swift ViewModels (iOS)
- ✅ JUnit for Kotlin ViewModels (Android)
This ensures platform-specific quality and integration while maintaining shared business logic.

## 📦 JSON Handling
- A local JSON string is used to simulate API responses instead of real network calls.
- DTOs are structured to support error handling, though error logic is not implemented for simplicity.

## 🚧 Known Simplifications
- DTOs include error fields, but no error-handling logic is used.
- JSON responses are hardcoded to avoid unnecessary complexity or setup.

## 🚀 Purpose
This project was built to demonstrate:
- Cross-platform development using Kotlin Multiplatform
- Native UI development best practices on iOS and Android
- Clean code organization using MVVM
- Modular and testable architecture