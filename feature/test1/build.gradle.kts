plugins {
    id("newdeps.android.library")
    id("newdeps.jetbrains.kotlin.android")
    id("newdeps.android.compose")
    id("newdeps.android.hilt")
}

android {
    namespace = "kr.chs.feature.test1"
}

java {
    sourceCompatibility = JavaVersion.VERSION_11
    targetCompatibility = JavaVersion.VERSION_11
}

dependencies {
    implementation(libs.androidx.activity.compose)
    implementation(libs.androidx.navigation.compose)
    implementation(libs.androidx.compose.material3)
}