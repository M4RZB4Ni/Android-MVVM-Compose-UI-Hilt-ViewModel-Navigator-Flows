plugins {
    id("com.android.library")
    id("org.jetbrains.kotlin.android")
    id("com.google.dagger.hilt.android")
    id("org.jetbrains.dokka")
    id("com.google.devtools.ksp")

}

android {
    namespace = "com.marzbani.domain"
    compileSdk = 34

    defaultConfig {
        minSdk = 26
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
//        tasks.dokkaHtmlPartial.dependsOn(":data:kaptDebugKotlin")

    }
}

dependencies {
    // Dagger Hilt dependencies
    implementation("com.google.dagger:hilt-android:2.50")
    ksp("com.google.dagger:hilt-android-compiler:2.50")

    // Kotlin dependencies
    api(platform("org.jetbrains.kotlin:kotlin-bom:1.9.22"))
    implementation("org.jetbrains.kotlinx:kotlinx-coroutines-android:1.7.3")

    // RxJava and Retrofit dependencies
    implementation("io.reactivex.rxjava2:rxandroid:2.1.1")
    implementation("io.reactivex.rxjava2:rxjava:2.2.21")
    implementation("com.squareup.retrofit2:adapter-rxjava2:2.9.0")

    // AndroidX dependencies
    implementation("androidx.core:core-ktx:1.12.0")
    implementation("androidx.appcompat:appcompat:1.6.1")
    implementation("com.google.android.material:material:1.11.0")

    // Testing dependencies
    testImplementation("junit:junit:4.13.2")
    testImplementation ("com.google.truth:truth:1.1")
    androidTestImplementation("androidx.test.ext:junit:1.1.5")
    androidTestImplementation("androidx.test.espresso:espresso-core:3.5.1")
    testImplementation ("androidx.arch.core:core-testing:2.2.0")
    testImplementation ("org.robolectric:robolectric:4.11.1")
    testImplementation ("org.mockito.kotlin:mockito-kotlin:5.2.1")

}


