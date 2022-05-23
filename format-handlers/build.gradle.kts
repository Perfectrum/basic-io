plugins {
    kotlin("jvm")
}

group = "org.example"
version = "1.0-SNAPSHOT"

repositories {
    maven("https://repo.kotlin.link")
    mavenCentral()
}

dependencies {
    implementation(kotlin("stdlib"))
    api("space.kscience:kmath-core-jvm:0.2.1")
    api("space.kscience:dataforge-tables-jvm:0.4.0")
}