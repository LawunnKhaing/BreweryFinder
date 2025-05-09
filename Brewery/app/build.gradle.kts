plugins {
    id("com.android.application")
    id("org.jetbrains.kotlin.android")
    id("org.qtproject.qt.gradleplugin") version "1.+"
}


QtBuild {
    qtPath = file("/home/lawunn/Qt/6.8.2")
    projectPath = file("/home/lawunn/qttest/qtquick_brewery/breweryfinder")
}

// android {
// For Qt 6.8 or older, add the following to your existing android {} section
//    packagingOptions.jniLibs.useLegacyPackaging = true
// }
android {
    namespace = "com.example.qtquickview_kotlin"
    compileSdk = 34
    ndkPath = "/home/lawunn/Android/Sdk/ndk"
    packagingOptions.jniLibs.useLegacyPackaging = true
    defaultConfig {

        applicationId = "com.example.qtquickview_kotlin"
        minSdk = 28
        targetSdk = 34
        versionCode = 1
        versionName = "1.0"

        testInstrumentationRunner = "androidx.test.runner.AndroidJUnitRunner"
    }

    buildFeatures {
        viewBinding = true
    }

    buildTypes {
        release {
            isMinifyEnabled = false
            proguardFiles(getDefaultProguardFile("proguard-android-optimize.txt"), "proguard-rules.pro")
        }
    }
    compileOptions {
        sourceCompatibility = JavaVersion.VERSION_1_8
        targetCompatibility = JavaVersion.VERSION_1_8
    }
    kotlinOptions {
        jvmTarget = "1.8"
    }
    packaging {
        jniLibs {
            useLegacyPackaging = true
        }
    }
    buildFeatures {
        viewBinding = true
    }
}

dependencies {
    implementation("androidx.core:core-ktx:1.13.1")
    implementation("androidx.appcompat:appcompat:1.7.0")
    implementation("com.google.android.material:material:1.12.0")
    implementation("androidx.constraintlayout:constraintlayout:2.1.4")
    testImplementation("junit:junit:4.13.2")
    androidTestImplementation("androidx.test.ext:junit:1.2.1")
    androidTestImplementation("androidx.test.espresso:espresso-core:3.6.1")
    implementation ("com.squareup.retrofit2:retrofit:2.9.0")
    implementation ("com.squareup.retrofit2:converter-gson:2.9.0")

}

