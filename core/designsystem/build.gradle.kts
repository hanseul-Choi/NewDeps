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

/**
 *  info : api는 A <- B <- C의 의존성을 가질 때, C에서 A를 접근할 수 있다.
 *  implementation은 A <- B <- C의 의존성을 가질 때, C에서 A를 접근할 수 없다.
 */
dependencies {
//    implementation(libs.androidx.activity.compose)
    implementation(platform(libs.androidx.compose.bom))
    implementation(libs.androidx.core.ktx)
    api(libs.androidx.compose.material3) // question : api와 implementation의 차이
    implementation(libs.androidx.compose.ui)
    implementation(libs.androidx.compose.material.iconsExtended)
}