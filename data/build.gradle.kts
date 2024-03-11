plugins {
    id("com.android.library")
    id("org.jetbrains.kotlin.android")
    id("com.google.dagger.hilt.android")
    id("org.jetbrains.dokka")
    id("com.google.devtools.ksp")

}

android {

    namespace = "com.marzbani.data"
    compileSdk = 34

    defaultConfig {
        minSdk = 26

        testInstrumentationRunner = "com.marzbani.data.HiltTestRunner"
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
    subprojects {
        apply(plugin = "org.jetbrains.dokka")
//        tasks.dokkaHtmlPartial.dependsOn(":data:kaptReleaseKotlin")
//
//        tasks.dokkaHtmlPartial.dependsOn(":data:kaptDebugKotlin")

    }
}


dependencies {
    // Project dependency
    implementation(project(":domain"))


    // Retrofit dependencies
    implementation("com.squareup.retrofit2:retrofit:2.9.0")
    implementation("com.squareup.okhttp3:logging-interceptor:4.12.0")
    implementation("com.squareup.okhttp3:okhttp:4.12.0")
    implementation("com.google.code.gson:gson:2.10.1")
    implementation("com.squareup.retrofit2:converter-gson:2.9.0")
    implementation("com.jakewharton.retrofit:retrofit2-kotlin-coroutines-adapter:0.9.2")
    implementation("org.jetbrains.kotlinx:kotlinx-serialization-core:1.3.1")


    // Dagger Hilt dependencies
    implementation("com.google.dagger:hilt-android:2.50")
    ksp("com.google.dagger:hilt-android-compiler:2.50")

}


