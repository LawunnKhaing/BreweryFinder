# 📌 Brewery Finder App (Kotlin + QML Integration)

## 📖 Overview
This project is a **Qt Quick for Android application** that fetches and displays **brewery information from Ireland**.  
The app identifies the following:
- 📍 **The northernmost brewery**
- 📍 **The southernmost brewery**
- 📍 **The brewery with the longest name**

🚀 **Tech Stack:**
- **Backend:** Kotlin (Handles API fetching & logic)
- **Frontend:** Hybrid UI (Android XML for some UI + QML for dynamic UI)
- **Tools & Frameworks:** Qt 6.8, Android Studio, CMake, Gradle, Retrofit (for API)

---

## 📌 Background Information
Qt Quick (QML) is **mostly used with C++**, making Kotlin integration rare.  
🔍 When searching online, I found almost no resources explaining how to **connect Kotlin with QML**.  
This project focuses on:
- **Exploring Kotlin-QML interaction** for Android apps.
- **Bridging communication between Kotlin and QML.**
- **Fetching real-time brewery data using APIs instead of local databases.**

## 📌 Creation Process

### **1️⃣ Setting Up the Environment**
✅ Installed **Qt 6.8**, **Qt for Android Studio Plugin**  
✅ Configured **Android SDK, NDK, Clang Compiler, and CMake**  
✅ Set up **Gradle and Qt dependencies** for smooth integration

### **2️⃣ Structuring the Project**
✅ Created a **Kotlin-based Android project**  
✅ Added new QT project  
✅ Configured **Qt Gradle plugin** for compiling QML modules

### **3️⃣ Implementing Features**
#### **🔹 Backend (Kotlin)**
✔ Used **Retrofit + Gson** to fetch brewery data from an API  
✔ Implemented logic to find the **northernmost, southernmost, and longest-name brewery**  
✔ Established **communication bridge between Kotlin and QML**

#### **🔹 Frontend (UI in XML + QML)**
✔ Used **XML layouts** for **Android-native UI elements** (buttons, text)  
✔ Integrated **QML inside Kotlin using `QtQuickView`** for a dynamic UI

---

## 📌 **Struggles & Learning Experience**

### **💥 Challenges Faced**
❌ **1. Connecting QML and Kotlin**
- No clear tutorials on **QtQuickView with Kotlin** (only C++ examples exist).
- Had to experiment with **QtQuickView, QML modules, and JNI communication**.
- Faced many **missing dependencies and Gradle errors**.

❌ **2. Setting Up the Build System**
- CMake path conflicts → **"Source directory mismatch" errors**
- Qt dependencies not found → **`Qt6Config.cmake` missing issue**
- **NDK, Clang, and C++ errors**, even though the main logic is in Kotlin

❌ **3. Gradle & Dependency Conflicts**
- Initial errors with `QtQuickView` and missing `org.qtproject` packages
- Had to manually add the **correct Gradle version for Qt compatibility**  

## Visuals
Here are some screenshots of the app:

| Home Screen                        | Catching Screen                            | Successful Fetch Screen                  |
|------------------------------------|--------------------------------------------|------------------------------------------|
| ![Login Screen](./images/picture1.jpeg) | ![Sleep Tracker](./images/Picture2.jpeg) | ![Home Screen](./images/picture3.jpeg) |
