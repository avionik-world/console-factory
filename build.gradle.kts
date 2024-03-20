plugins {
    kotlin("jvm") version "1.9.23"
    `maven-publish`
}

group = "world.avionik"
version = "1.0.1"

repositories {
    mavenCentral()
}

dependencies {
    compileOnly(kotlin("stdlib"))
    runtimeOnly(kotlin("stdlib"))

    // jline dependencies
    api("org.jline:jline:3.25.1")
}

publishing {
    repositories {
        maven {
            name = "GitHubPackages"
            url = uri("https://maven.pkg.github.com/avionik-world/console-factory")
            credentials {
                username = project.findProperty("gpr.user") as String? ?: System.getenv("USERNAME")
                password = project.findProperty("gpr.key") as String? ?: System.getenv("TOKEN")
            }
        }
    }
    publications {
        register<MavenPublication>("gpr") {
            from(components["java"])
        }
    }
}