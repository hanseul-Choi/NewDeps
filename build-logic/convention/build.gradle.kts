plugins {
    `kotlin-dsl`
}

group = "com.ldcc.newdeps.buildlogic"

java {
    sourceCompatibility = JavaVersion.VERSION_11
    targetCompatibility = JavaVersion.VERSION_11
}

dependencies {
    compileOnly(libs.android.gradlePlugin)
    compileOnly(libs.kotlin.gradlePlugin)
//    compileOnly(libs.ksp.gradlePlugin)
}

gradlePlugin {
    plugins {
        register("androidApplication") {
            id = "newdeps.android.application"
            implementationClass = "AndroidApplicationConventionPlugin"
        }

        register("androidKotlin") {
            id = "newdeps.jetbrains.kotlin.android"
            implementationClass = "AndroidKotlinConventionPlugin"
        }

        register("androidLibrary") {
            id = "newdeps.android.library"
            implementationClass = "AndroidLibraryConventionPlugin"
        }

        register("androidCompose") {
            id = "newdeps.android.compose"
            implementationClass = "AndroidComposeConventionPlugin"
        }

        register("androidHilt") {
            id = "newdeps.android.hilt"
            implementationClass = "AndroidHiltConventionPlugin"
        }
        //Here is the place to register plugins
//        register()
    }
}