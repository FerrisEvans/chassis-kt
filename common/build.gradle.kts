plugins {
    alias(libs.plugins.ksp)
    id("buildsrc.convention.kotlin-jvm")
    alias(libs.plugins.kotlinPluginSerialization)
}

dependencies {
    implementation(libs.bundles.kotlinxEcosystem)
    implementation(libs.bundles.springbootStarter)
    implementation(libs.bundles.jdbc)
    testImplementation(libs.bundles.test)
}