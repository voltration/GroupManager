plugins {
    kotlin("jvm") version "1.9.21"
}

group = "lol.ssmp"
version = "1.0-SNAPSHOT"

repositories {
    mavenCentral()
    maven("https://hub.spigotmc.org/nexus/content/repositories/snapshots/")
    maven("https://oss.sonatype.org/content/repositories/snapshots")
    maven("https://oss.sonatype.org/content/repositories/central")
}

dependencies {
    implementation("org.jetbrains.exposed:exposed-core:0.45.0")
    implementation("mysql:mysql-connector-java:8.0.28")
    implementation("org.spigotmc:spigot-api:1.20.2-R0.1-SNAPSHOT")
}
tasks.test {
    useJUnitPlatform()
}

kotlin {
    jvmToolchain(8)
}
