plugins {
    `kotlin-dsl`
}

repositories {
    google()
    gradlePluginPortal()
}

dependencies {
    implementation(kotlin("gradle-plugin", version = "1.8.20"))
    implementation(kotlin("serialization", version = "1.8.20"))

    implementation("gradle.plugin.org.cadixdev.gradle", "licenser", "0.6.1")
    implementation("com.github.jakemarsden", "git-hooks-gradle-plugin", "0.0.2")
    implementation("com.google.devtools.ksp", "com.google.devtools.ksp.gradle.plugin", "1.8.20-1.0.11")
    implementation("io.gitlab.arturbosch.detekt", "detekt-gradle-plugin", "1.22.0")
    implementation("org.jetbrains.dokka", "dokka-gradle-plugin", "1.8.10")

    implementation(gradleApi())
    implementation(localGroovy())
}
