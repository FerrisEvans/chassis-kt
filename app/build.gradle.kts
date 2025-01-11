plugins {
    id("buildsrc.convention.kotlin-jvm")
    application
}

dependencies {
    // Project "app" depends on project "common". (Project paths are separated with ":", so ":common" refers to the top-level "utils" project.)
    implementation(project(":common"))
    implementation(project(":sys"))
    implementation(libs.bundles.kotlinxEcosystem)
    implementation(libs.bundles.springbootStarter)
    implementation(libs.bundles.jdbc)
    implementation(libs.starter.actuator)
    testImplementation(libs.bundles.test)
}

application {
    // Define the Fully Qualified Name for the application main class
    // (Note that Kotlin compiles `App.kt` to a class with FQN `com.example.app.AppKt`.)
    mainClass = "cn.dd.AppApplication"
}
