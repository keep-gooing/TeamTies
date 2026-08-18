plugins {
    alias(libs.plugins.android.application) apply false
    alias(libs.plugins.android.library) apply false
    alias(libs.plugins.kotlin.main) apply false
    alias(libs.plugins.kotlin.compose) apply false
    alias(libs.plugins.ksp) apply false
    id("com.google.dagger.hilt.android") version libs.versions.hilt.get() apply false
    alias(libs.plugins.jetbrains.kotlin.jvm) apply false
}
