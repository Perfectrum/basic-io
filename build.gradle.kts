import org.jetbrains.kotlin.gradle.tasks.KotlinCompile

tasks.withType<KotlinCompile>().all {
    kotlinOptions {
        freeCompilerArgs = listOf("-opt-in=kotlin.RequiresOptIn", "-Xexplicit-api=warning")
        jvmTarget = "11"
    }
}

plugins {
    kotlin("jvm") version "1.6.20"
}

repositories {
    maven("https://repo.kotlin.link")
    mavenCentral()
}

dependencies {
    implementation(kotlin("stdlib"))
    api("space.kscience:kmath-core-jvm:0.2.1")
    api("space.kscience:dataforge-tables-jvm:0.4.0")
    implementation("junit:junit:4.13.1")
    implementation("space.kscience:tables-kt:0.1.3")
}