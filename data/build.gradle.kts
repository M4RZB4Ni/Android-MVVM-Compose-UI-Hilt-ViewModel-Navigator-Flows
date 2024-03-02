plugins {
    id("com.android.library")
    id("org.jetbrains.kotlin.android")
    id("com.google.dagger.hilt.android")
    id("org.jetbrains.dokka")
    kotlin("kapt")
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
}

dependencies {
    // Project dependency
    implementation(project(":domain"))

    // Dagger Hilt dependencies
    implementation("com.google.dagger:hilt-android:2.50")
    testImplementation("junit:junit:4.13.2")
    kapt("com.google.dagger:hilt-android-compiler:2.50")

    // Retrofit dependencies
    api("com.squareup.retrofit2:retrofit:2.9.0")
    api("com.squareup.retrofit2:adapter-rxjava2:2.9.0")
    api("com.squareup.okhttp3:logging-interceptor:4.12.0")
    api("com.squareup.okhttp3:okhttp:4.12.0")
    api("com.google.code.gson:gson:2.10.1")
    api("com.squareup.retrofit2:converter-gson:2.9.0")

    // RxJava dependencies
    implementation("io.reactivex.rxjava2:rxandroid:2.1.1")
    implementation("io.reactivex.rxjava2:rxjava:2.2.21")

    // Mockito framework and mockito-kotlin for testing
    testImplementation("org.mockito:mockito-core:5.11.0")
    testImplementation("org.mockito.kotlin:mockito-kotlin:5.2.1")

    // AndroidX dependencies
    implementation("androidx.core:core-ktx:1.12.0")
    implementation("androidx.appcompat:appcompat:1.6.1")
    implementation("com.google.android.material:material:1.11.0")

    // JUnit and MockK for testing
    testImplementation("junit:junit:4.13.2")
    testImplementation("io.mockk:mockk:1.13.8")
    testImplementation("androidx.test:runner:1.5.2")
    testImplementation("com.google.dagger:hilt-android-testing:2.50")
    kaptTest("com.google.dagger:hilt-android-compiler:2.50")
    testImplementation("org.robolectric:robolectric:4.5.1")


}

kapt {
    correctErrorTypes = true
}
