# 🌑 Relax Inn — The Art of Booking

![Kotlin](https://img.shields.io/badge/Kotlin-1.9.0-7F52FF?style=for-the-badge&logo=kotlin&logoColor=white)
![Jetpack Compose](https://img.shields.io/badge/Jetpack%20Compose-UI-4285F4?style=for-the-badge&logo=android&logoColor=white)
![Firebase](https://img.shields.io/badge/Backend-Firebase%20Firestore-FFCA28?style=for-the-badge&logo=firebase&logoColor=black)
![Architecture](https://img.shields.io/badge/Architecture-Clean%20%2B%20MVVM-4CAF50?style=for-the-badge)

> *Find your peace. Book your stay. Experience the dark side of design.*

**Relax Inn** is a cutting-edge Android hotel booking application that marries a sophisticated **Dark Gunmetal & Terracotta** aesthetic with the raw power of **Serverless Cloud Architecture**. 

Built strictly with **Clean Architecture** principles, this project is a showcase of how modern Android development (Jetpack Compose) can seamlessly integrate with NoSQL databases (Firestore) to create fluid, real-time user experiences.

---

## 📸 The Vibe (UI Showcase)

We ditched the standard white screens for a custom **High-Contrast Dark Theme**. 
- **Backgrounds:** Deep Gunmetal (`#181A20`)
- **Accents:** Terracotta & Powder Blue (`#DE856C`, `#9FBDE2`)

<p align="center">
  <img src="docs/hero.png" width="240" alt="Hero Screen" style="border-radius: 10px; margin-right: 10px;">
  <img src="docs/home.png" width="240" alt="Home Screen" style="border-radius: 10px; margin-right: 10px;">
  <img src="docs/detail.png" width="240" alt="Detail Screen" style="border-radius: 10px;">
</p>

---

## 🛠 Under the Hood

### The Stack
* **Language:** [Kotlin](https://kotlinlang.org/) (100% Native)
* **UI Toolkit:** [Jetpack Compose](https://developer.android.com/jetpack/compose) (No XML)
* **Dependency Injection:** [Hilt](https://dagger.dev/hilt/)
* **Backend:** [Firebase Firestore](https://firebase.google.com/products/firestore) (Cloud Database)
* **Navigation:** [Compose Navigation](https://developer.android.com/guide/navigation)
* **Async:** Coroutines & StateFlow

### The Architecture
The app follows a strict **Clean Architecture** pattern to ensure scalability and testability:

1.  **Presentation Layer:** * Reactive Composables observing `StateFlow`.
    * ViewModels that handle UI logic and user intent.
2.  **Domain Layer:** * Pure Kotlin UseCases (e.g., `GetHotelsUseCase`, `BookRoomUseCase`).
    * Repository Interfaces defining *what* data we need, not *how* we get it.
3.  **Data Layer:** * **Firestore Implementations:** Real-time data fetching.
    * **DTO Mappers:** Converting NoSQL documents into safe Domain Entities.

---

## 🔥 Key Features

* **Cloud-Native Data:** Hotels, prices, and amenities are fetched dynamically from **Firestore Collections**, allowing for instant content updates without app releases.
* **Smart Authentication:** Custom login flows with validation and secure entry.
* **Immersive Discovery:** Horizontal scrolling feeds, category chips (Hotels, Flights, Restaurants), and rich imagery.
* **Themed Design System:** A centralized `UnifiedAppColors` theme engine that ensures consistency across every pixel.

---

## 🚀 Getting Started

1.  **Clone the Repo**
    ```bash
    git clone [https://github.com/your-username/relax-inn.git](https://github.com/AsadAhmad01/RelaxInn.git)
    ```

2.  **Connect Firebase**
    * Create a project in the [Firebase Console](https://console.firebase.google.com/).
    * Add an Android App (`com.example.relaxinn`).
    * Download `google-services.json` and place it in the `/app` folder.

3.  **Run & Relax**
    * Open in Android Studio.
    * Sync Gradle.
    * Hit Run ▶️.

---

## 🤝 Contribution

Got a cool idea? Want to add **Room Database Caching** or **Google Maps** integration? 

1.  Fork the Project.
2.  Create your Feature Branch (`git checkout -b feature/AmazingFeature`).
3.  Commit your Changes (`git commit -m 'Add some AmazingFeature'`).
4.  Push to the Branch (`git push origin feature/AmazingFeature`).
5.  Open a Pull Request.

---

<p align="center">
  Made with ❤️, ☕, and a lot of <code>suspend</code> functions.
</p>
