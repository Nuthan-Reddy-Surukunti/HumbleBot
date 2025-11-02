# HumbleBot 🤖

A modern, beautiful Android AI chatbot application powered by Google's Gemini 2.5 Flash API. Built with Jetpack Compose, Material 3 Design, and following clean architecture principles.

<div align="center">
  <img src="https://img.shields.io/badge/Android-3DDC84?style=for-the-badge&logo=android&logoColor=white" alt="Android"/>
  <img src="https://img.shields.io/badge/Kotlin-7F52FF?style=for-the-badge&logo=kotlin&logoColor=white" alt="Kotlin"/>
  <img src="https://img.shields.io/badge/Jetpack%20Compose-4285F4?style=for-the-badge&logo=jetpackcompose&logoColor=white" alt="Jetpack Compose"/>
  <img src="https://img.shields.io/badge/Material%203-757575?style=for-the-badge&logo=material-design&logoColor=white" alt="Material 3"/>
</div>

## ✨ Features

### 🎨 Beautiful UI
- **Modern Material 3 Design** with custom color scheme
- **Light & Dark Theme** support with seamless switching
- **Smooth Animations** for message appearance and interactions
- **Typing Indicator** with animated dots while AI responds
- **Empty State** with suggested conversation starters
- **Message Bubbles** with distinct styling for user and AI messages

### 🚀 Performance Optimized
- **LazyColumn** with efficient item rendering and key-based composition
- **StateFlow** for reactive state management
- **Coroutines** for asynchronous API calls
- **60fps** smooth scrolling experience
- **Memory efficient** message list handling

### 🤖 AI Integration
- **Google Gemini 2.5 Flash** API integration
- **Real-time responses** from advanced AI model
- **Error handling** with user-friendly messages
- **Retry mechanism** for failed requests

### 💡 User Experience
- **Auto-scroll** to latest messages
- **Suggested prompts** for easy conversation starters
- **Clear chat** functionality
- **Input validation** with disabled send when empty
- **Loading states** with visual feedback
- **Snackbar notifications** for errors

## 📱 Screenshots

> Add screenshots of your app here

## 🛠 Tech Stack

### Core Technologies
- **Language**: Kotlin 1.9+
- **UI Framework**: Jetpack Compose
- **Design System**: Material 3
- **Minimum SDK**: 24 (Android 7.0)
- **Target SDK**: 35 (Android 15)
- **Compile SDK**: 35

### Architecture & Libraries
- **Architecture Pattern**: MVVM (Model-View-ViewModel)
- **State Management**: StateFlow, ViewModel
- **Networking**: 
  - Retrofit 2.9.0
  - OkHttp3
  - Gson Converter
- **Async Operations**: Kotlin Coroutines 1.8.1
- **Lifecycle**: 
  - Lifecycle ViewModel Compose 2.8.5
  - Lifecycle Runtime Compose 2.8.5
- **Dependency Injection**: Manual (can be upgraded to Hilt/Koin)

## 📂 Project Structure

```
app/src/main/java/com/humblecoders/humblebot/
├── api/
│   ├── GeminiApi.kt              # Retrofit API interface
│   └── NetworkClient.kt          # Retrofit client configuration
├── model/
│   ├── ChatMessage.kt            # Chat message data class
│   ├── GeminiRequest.kt          # API request models
│   ├── GeminiResponse.kt         # API response models
│   ├── Content.kt                # Content model for API
│   └── Part.kt                   # Part model for API
├── repository/
│   └── ChatRepository.kt         # Data layer for API calls
├── viewmodel/
│   └── ChatViewModel.kt          # UI state management
├── ui/
│   ├── screens/
│   │   └── ChatScreen.kt         # Main chat screen UI
│   ├── components/
│   │   ├── MessageBubble.kt      # Message bubble component
│   │   ├── TypingIndicator.kt   # Animated typing indicator
│   │   └── EmptyState.kt         # Empty state with suggestions
│   └── theme/
│       ├── Color.kt              # App color palette
│       ├── Theme.kt              # Material 3 theme setup
│       └── Type.kt               # Typography definitions
└── MainActivity.kt               # App entry point
```

## 🚀 Getting Started

### Prerequisites

- **Android Studio**: Hedgehog (2023.1.1) or later recommended
- **JDK**: 11 or higher
- **Google Gemini API Key**: Get it from [Google AI Studio](https://makersuite.google.com/app/apikey)

### Installation Steps

1. **Clone the repository**
   ```bash
   git clone https://github.com/Humble-Coders/HumbleBot.git
   cd HumbleBot
   ```

2. **Open in Android Studio**
   - Launch Android Studio
   - Select "Open an Existing Project"
   - Navigate to the cloned repository folder
   - Wait for Gradle sync to complete

3. **Add your Gemini API Key**
   - Open `app/src/main/java/com/humblecoders/humblebot/repository/ChatRepository.kt`
   - Find the `sendMessage` function
   - Replace the empty `apiKey` parameter:
   ```kotlin
   val response = geminiApi.generateContent(
       apiKey = "YOUR_API_KEY_HERE", // Replace with your actual API key
       request = request
   )
   ```

4. **Build and Run**
   - Connect an Android device or start an emulator
   - Click the "Run" button (▶️) in Android Studio
   - Select your device/emulator
   - Wait for the app to build and install

## 🎨 UI Components

### ChatScreen
The main screen containing:
- Top app bar with bot avatar and clear chat button
- Message list with reverse scrolling (latest at bottom)
- Input field with send button
- Smooth animations and auto-scroll

### MessageBubble
Displays individual messages with:
- Different styling for user vs AI messages
- Rounded corners with asymmetric design
- Proper contrast colors for light/dark themes
- Maximum width constraints for readability

### TypingIndicator
Animated loading indicator with:
- Three bouncing dots
- Staggered animation timing
- Theme-aware colors

### EmptyState
Welcome screen featuring:
- Friendly greeting message
- Four suggested conversation starters
- Clean, centered layout

## 🔧 Configuration

### API Endpoint
Base URL: `https://generativelanguage.googleapis.com`
Endpoint: `/v1beta/models/gemini-2.5-flash:generateContent`

### Theme Customization
Edit colors in `app/src/main/java/com/humblecoders/humblebot/ui/theme/Color.kt`:
```kotlin
val Primary = Color(0xFF6366F1)        // Change primary color
val UserBubble = Color(0xFF6366F1)     // User message bubble
val AIBubble = Color(0xFFE5E7EB)       // AI message bubble
```

### Model Selection
To use a different Gemini model, update `GeminiApi.kt`:
```kotlin
@POST("/v1beta/models/gemini-1.5-pro:generateContent") // Change model here
suspend fun generateContent(...)
```

## 🧪 Testing

### Run Unit Tests
```bash
./gradlew test
```

### Run Instrumented Tests
```bash
./gradlew connectedAndroidTest
```

## 📝 API Key Security

**⚠️ Important**: Never commit your API key to version control!

### Recommended Approach
1. Create a `local.properties` file (already gitignored)
2. Add your API key:
   ```properties
   GEMINI_API_KEY=your_actual_api_key_here
   ```
3. Read it in `build.gradle.kts`:
   ```kotlin
   android {
       defaultConfig {
           buildConfigField("String", "GEMINI_API_KEY", "\"${properties["GEMINI_API_KEY"]}\"")
       }
   }
   ```
4. Use it in code:
   ```kotlin
   apiKey = BuildConfig.GEMINI_API_KEY
   ```

## 🤝 Contributing

Contributions are welcome! Please follow these steps:

1. Fork the repository
2. Create a feature branch (`git checkout -b feature/AmazingFeature`)
3. Commit your changes (`git commit -m 'Add some AmazingFeature'`)
4. Push to the branch (`git push origin feature/AmazingFeature`)
5. Open a Pull Request

## 📄 License

This project is licensed under the MIT License - see the [LICENSE](LICENSE) file for details.

## 🙏 Acknowledgments

- **Google Gemini** for the amazing AI API
- **Jetpack Compose** team for the modern UI toolkit
- **Material Design** for the beautiful design system
- **Humble Coders** community for support and feedback

## 📧 Contact

- **GitHub**: [@Humble-Coders](https://github.com/Humble-Coders)
- **Email**: support@humblecoders.com

## 🗺 Roadmap

- [ ] Add markdown rendering for AI responses
- [ ] Implement message copy/share functionality
- [ ] Add voice input support
- [ ] Implement conversation history persistence
- [ ] Add multi-turn conversation context
- [ ] Support for image inputs
- [ ] Export chat feature
- [ ] Custom AI personality settings
- [ ] Rate limiting and usage tracking
- [ ] Offline mode with cached responses

---

<div align="center">
  Made with ❤️ by <a href="https://github.com/Humble-Coders">Humble Coders</a>
</div>
  - Current placeholder is empty: `apiKey = ""`
  - Replace with your key: `apiKey = "YOUR_API_KEY"`

4) Run the app
- Select a device/emulator
- Press Run ▶ in Android Studio

### Using the data layer
`ChatRepository.sendMessage(message: String)` builds a `GeminiRequest` and returns a `Result<String>` with the model’s first reply text when successful. You can wire this into your Compose UI or ViewModel of choice.

### Notes and limitations
- The UI layer is intentionally minimal; you can add a chat screen on top of the existing repository and models.
- Network logging is enabled via OkHttp logging interceptor in `NetworkClient.kt`.

### Troubleshooting
- 401/403 errors: Verify you set a valid API key and that it has access to the Gemini model `gemini-2.5-flash`.
- Build issues: Ensure Android Studio uses JDK 11 and that Gradle sync completes without errors.
- Connectivity: The app requires internet permission (already declared in `AndroidManifest.xml`).

### Roadmap ideas
- Add a Compose chat UI with message history
- Stream responses and partial rendering
- Persist conversation to local storage
- Error and retry UI states

### License
Specify a license for this project (e.g., MIT) or add a `LICENSE` file.


