plugins {
    id("com.android.library")
    id("org.jetbrains.kotlin.android")
    id("com.google.dagger.hilt.android")
    id("org.jetbrains.dokka")
    id("com.google.devtools.ksp")
}

android {
    namespace = "com.marzbani.presentation"
    compileSdk = 34

    defaultConfig {
        minSdk = 26

        testInstrumentationRunner = "com.marzbani.presentation.di.HiltTestRunner"
        vectorDrawables {
            useSupportLibrary = true
        }
    }


    hilt {
        enableAggregatingTask = true
    }
    compileOptions {
        sourceCompatibility = JavaVersion.VERSION_1_8
        targetCompatibility = JavaVersion.VERSION_1_8
    }
    kotlinOptions {
        jvmTarget = "1.8"
    }
    buildFeatures {
        compose = true
    }
    composeOptions {
        kotlinCompilerExtensionVersion = "1.5.1"
    }
    packaging {
        resources {
            excludes += "/META-INF/{AL2.0,LGPL2.1}"
        }
    }
    subprojects {
        apply(plugin = "org.jetbrains.dokka")
//        tasks.dokkaHtmlPartial.dependsOn(":presentation:kaptReleaseKotlin")

    }
}

dependencies {

    // Project dependency
    implementation(project(":domain"))

    // Dagger Hilt dependencies
    implementation("com.google.dagger:hilt-android:2.50")
    implementation("androidx.hilt:hilt-navigation-compose:1.2.0")
    ksp("com.google.dagger:hilt-android-compiler:2.50")

    // Compose dependencies
    implementation(platform("androidx.compose:compose-bom:2024.02.02"))
    implementation("androidx.compose.ui:ui-tooling-preview")
    implementation("androidx.compose.material3:material3")

}

