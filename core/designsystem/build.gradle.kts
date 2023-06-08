plugins {
    id("newdeps.android.library")
    id("newdeps.jetbrains.kotlin.android")
    id("newdeps.android.compose")
}

android {
    namespace = "com.ldcc.newdeps.core.designsystem"

    defaultConfig {
        testInstrumentationRunner = "androidx.test.runner.AndroidJUnitRunner"
    }
}

dependencies {
//    implementation(libs.androidx.activity.compose)
    implementation(libs.androidx.core.ktx)
    implementation(libs.androidx.compose.material3)
    implementation(libs.androidx.compose.ui)
}