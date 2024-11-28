plugins {
    kotlin("jvm") version "2.0.21"
}

dependencies {
    api(libs.yutori)
}

kotlin {
    jvmToolchain(17)
}

publishing {
    publications.withType<MavenPublication> {
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