plugins {
    alias(libs.plugins.android.application)
    alias(libs.plugins.kotlin.android)
    id("com.google.gms.google-services")

    id("com.google.firebase.crashlytics")

}

android {
    namespace = "com.alberto.practica17"
    compileSdk = 35

    defaultConfig {
        applicationId = "com.alberto.practica17"
        minSdk = 24
        targetSdk = 34
        versionCode = 1
        versionName = "1.0"

        testInstrumentationRunner = "androidx.test.runner.AndroidJUnitRunner"
    }

    buildTypes {
        release {
            isMinifyEnabled = false
            proguardFiles(
                getDefaultProguardFile("proguard-android-optimize.txt"),
                "proguard-rules.pro"
            )
        }
    }
    compileOptions {
        sourceCompatibility = JavaVersion.VERSION_1_8
        targetCompatibility = JavaVersion.VERSION_1_8
    }
    kotlinOptions {
        jvmTarget = "1.8"
    }

    buildFeatures {
        viewBinding = true
    }
}

dependencies {

    // Firebase BoM
    implementation(platform("com.google.firebase:firebase-bom:33.6.0"))
    // Analytics
    implementation("com.google.firebase:firebase-analytics-ktx")
    // CrashLytics
    implementation("com.google.firebase:firebase-crashlytics-ktx")
    // Auth
    implementation("com.google.firebase:firebase-auth-ktx")
    // Google Auth
    implementation("com.google.android.gms:play-services-auth:20.7.0")
    // Cloud Messaging (Mensajes Push)
    implementation("com.google.firebase:firebase-messaging-ktx")
    // Remote Config
    implementation("com.google.firebase:firebase-config-ktx")
    // Firebase Firestore
    implementation("com.google.firebase:firebase-firestore-ktx")
    // RealTime Database
    implementation("com.google.firebase:firebase-database-ktx")


    implementation(libs.androidx.core.ktx)
    implementation(libs.androidx.appcompat)
    implementation(libs.material)
    implementation(libs.androidx.activity)
    implementation(libs.androidx.constraintlayout)
    testImplementation(libs.junit)
    androidTestImplementation(libs.androidx.junit)
    androidTestImplementation(libs.androidx.espresso.core)
}