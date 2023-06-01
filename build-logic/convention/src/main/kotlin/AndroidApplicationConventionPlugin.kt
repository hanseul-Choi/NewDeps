import com.android.build.api.dsl.ApplicationExtension
import com.ldcc.newdeps.configureAndroidApplication
import com.ldcc.newdeps.configureAndroidCommon
import org.gradle.api.Plugin
import org.gradle.api.Project
import org.gradle.kotlin.dsl.configure

class AndroidApplicationConventionPlugin : Plugin<Project> {
    override fun apply(target: Project) {
        with(target) {
            with(pluginManager) {
                apply("com.android.application")
//                apply("com.google.devtools.ksp")
            }

            // ApplicationExtension : Android Application Module에서만 동작한다
            // 또한, com.android.application에 적합하다
            // com.android.library plugin을 다루려면 LibraryExtension을 이용해야하낟.
            extensions.configure<ApplicationExtension> {
                configureAndroidCommon(this)
                configureAndroidApplication(this)
            }
        }
    }
}