plugins {
    kotlin("jvm") version "2.0.21"
    id("maven-publish")
}

group = "cn.yurin.yutori.bridge"

dependencies {
    api(libs.yutori)
}

kotlin {
    jvmToolchain(17)
}

publishing {
    repositories {
        maven {
            name = "GitHubPackages"
            url = uri("https://maven.pkg.github.com/Nyayurin/yutori-bridge-java")
            credentials {
                username = System.getenv("GITHUB_ACTOR")
                password = System.getenv("GITHUB_TOKEN")
            }
        }
    }
    publications.register<MavenPublication>("gpr") {
        from(components["java"])
        pom {
            name = "Yutori-Bridge-Java"
            version = System.getenv("VERSION")
            description = "Kotlin Multiplatform library"
            url = "https://github.com/Nyayurin/yutori-bridge-java"

            developers {
                developer {
                    id = "Nyayurin"
                    name = "Yurin"
                    email = "Nyayurn@outlook.com"
                }
            }
            scm {
                url = "https://github.com/Nyayurin/yutori-bridge-java"
            }
        }
    }
}