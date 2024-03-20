import com.github.jengelman.gradle.plugins.shadow.tasks.ShadowJar

plugins {
    kotlin("jvm") version "1.9.23"
    id("com.github.johnrengelman.shadow") version "8.1.1"
    alias(libs.plugins.sonatypeCentralPortalPublisher)
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

tasks.named("shadowJar", ShadowJar::class) {
    mergeServiceFiles()
}

signing {
    useGpgCmd()
    sign(configurations.archives.get())
}

centralPortal {
    username = project.findProperty("sonatypeUsername") as String
    password = project.findProperty("sonatypePassword") as String

    pom {
        name.set("Console Factory")
        description.set("Create commands in the console with JLine")
        url.set("https://github.com/avionik-world/console-factory")

        developers {
            developer {
                id.set("niklasnieberler")
                email.set("admin@avionik.world")
            }
        }
        licenses {
            license {
                name.set("Apache-2.0")
                url.set("https://www.apache.org/licenses/LICENSE-2.0.txt")
            }
        }
        scm {
            url.set("https://github.com/avionik-world/console-factory.git")
            connection.set("git:git@github.com:avionik-world/console-factory.git")
        }
    }
}