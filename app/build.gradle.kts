plugins {
    id("newdeps.android.application")
    id("newdeps.jetbrains.kotlin.android")
    id("newdeps.android.compose")
    id("newdeps.android.hilt")
}

android {
    namespace = "com.ldcc.newdeps"

    defaultConfig {
        applicationId = "com.ldcc.newdeps"
        versionCode = 1
        versionName = "1.0"

        testInstrumentationRunner = "androidx.test.runner.AndroidJUnitRunner"
    }

    buildTypes {
        getByName("release") {
            isMinifyEnabled = false
            proguardFiles(getDefaultProguardFile("proguard-android-optimize.txt"), "proguard-rules.pro")
        }
    }
}

dependencies {

    implementation(project(":core:designsystem"))
    implementation(project(":feature:test1"))
    implementation(project(":feature:test2"))

    implementation(libs.androidx.activity.compose)
    implementation(libs.androidx.compose.material3)
    implementation(libs.androidx.compose.ui)
    implementation(libs.androidx.compose.ui.tooling.preview)
    implementation(libs.androidx.navigation.compose)

    testImplementation(libs.junit4)
    androidTestImplementation(libs.androidx.test.ext)
    androidTestImplementation(libs.androidx.test.espresso.core)

    debugImplementation(libs.androidx.compose.ui.tooling)
}