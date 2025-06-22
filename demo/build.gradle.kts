plugins { alias(libs.plugins.jvm) }

group = "io.ravenzip"

version = "1.0.0"

dependencies {
    implementation(libs.kotlin.coroutines)
    implementation(project(":ruvilet"))
}

kotlin { jvmToolchain(22) }
