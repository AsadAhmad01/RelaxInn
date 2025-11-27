plugins {
    alias(libs.plugins.android.application)
    alias(libs.plugins.kotlin.android)
    alias(libs.plugins.kotlin.kapt)
    alias(libs.plugins.hilt.android)
    alias(libs.plugins.compose)
    id("kotlin-parcelize")
}

android {
    namespace = "com.project.relaxinn"
    compileSdk {
        version = release(36)
    }

    defaultConfig {
        applicationId = "com.project.relaxinn"
        minSdk = 24
        targetSdk = 36
        versionCode = 1
        versionName = "1.0"

        testInstrumentationRunner = "androidx.test.runner.AndroidJUnitRunner"
        
        // Default base URL (can be overridden by build types)
        buildConfigField("String", "BASE_URL", "\"https://your-api-base-url.com/api/\"")
    }

    buildTypes {
        debug {
            buildConfigField("String", "BASE_URL", "\"https://dev-api.example.com/api/\"")
        }
        release {
            isMinifyEnabled = false
            proguardFiles(
                getDefaultProguardFile("proguard-android-optimize.txt"),
                "proguard-rules.pro"
            )
            buildConfigField("String", "BASE_URL", "\"https://api.example.com/api/\"")
        }
    }
    compileOptions {
        sourceCompatibility = JavaVersion.VERSION_17
        targetCompatibility = JavaVersion.VERSION_17
    }
    kotlinOptions {
        jvmTarget = "17"
    }
    buildFeatures {
        compose = true
        buildConfig = true
    }
    composeOptions {
        kotlinCompilerExtensionVersion = "1.5.8"
    }
}

kapt {
    correctErrorTypes = true
}

dependencies {
    // Core Android
    implementation(libs.androidx.core.ktx)
    implementation(libs.androidx.appcompat)
    implementation(libs.material)
    implementation(libs.androidx.activity)
    implementation(libs.androidx.constraintlayout)
    implementation(libs.coil.compose)
    implementation(libs.coil.gif)


    // Hilt Dependency Injection
    implementation(libs.hilt.android)
    implementation(libs.androidx.lifecycle.runtime.compose)
    implementation(libs.androidx.foundation)
    implementation(libs.androidx.ui.text)
    implementation(libs.androidx.animation)
    implementation(libs.androidx.ui.graphics)
    implementation(libs.androidx.foundation.layout)
    implementation(libs.ui.graphics)
    implementation(libs.androidx.material3)
    androidTestImplementation(platform(libs.compose.bom))
    androidTestImplementation(libs.androidx.ui.test.junit4)
    kapt(libs.hilt.compiler)
    implementation(libs.hilt.navigation.compose)
    
    // Retrofit & Networking
    implementation(libs.retrofit)
    implementation(libs.retrofit.gson)
    implementation(libs.okhttp)
    implementation(libs.okhttp.logging)
    implementation(libs.gson)
    
    // Coroutines
    implementation(libs.coroutines.core)
    implementation(libs.coroutines.android)
    
    // Lifecycle & ViewModel
    implementation(libs.lifecycle.viewmodel)
    implementation(libs.lifecycle.livedata)
    implementation(libs.lifecycle.runtime)
    
    // Navigation
    implementation(libs.navigation.fragment)
    implementation(libs.navigation.ui)
    implementation(libs.navigation.compose)
    
    // ViewPager2
    implementation(libs.viewpager2)
    
    // CardView
    implementation(libs.androidx.cardview)
    
    // Compose BOM
    implementation(platform(libs.compose.bom))
    implementation(libs.compose.ui)
    implementation(libs.compose.ui.tooling.preview)
    implementation(libs.compose.material3)
    implementation(libs.compose.activity)
    implementation(libs.compose.viewmodel)
    implementation(libs.compose.runtime.livedata)
    implementation(libs.compose.navigation)
    implementation(libs.compose.hilt.navigation)
    implementation(libs.compose.foundation)
    implementation(libs.compose.material.icons.extended)
    
    // Compose Debug
    debugImplementation(libs.compose.ui.tooling)
    debugImplementation(libs.compose.ui.test.manifest)
    
    // DataStore Preferences
    implementation(libs.datastore.preferences)
    
    // Logging
    implementation(libs.timber)
    
    // Testing
    testImplementation(libs.junit)
    androidTestImplementation(libs.androidx.junit)
    androidTestImplementation(libs.androidx.espresso.core)
}