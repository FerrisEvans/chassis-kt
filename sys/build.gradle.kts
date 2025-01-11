plugins {
    id("buildsrc.convention.kotlin-jvm")
    alias(libs.plugins.kotlinPluginSerialization)
}

dependencies {
    implementation(project(":common"))
    implementation(libs.bundles.kotlinxEcosystem)
    implementation(libs.bundles.springbootStarter)
    implementation(libs.bundles.jdbc)
    testImplementation(libs.bundles.test)
}