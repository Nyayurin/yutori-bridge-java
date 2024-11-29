plugins {
    kotlin("jvm") version "2.0.21"
    java
}

dependencies {
    api(libs.yutori)
}

java {
    withSourcesJar()
}

kotlin {
    jvmToolchain(17)
}

publishing {
    publications {
        register<MavenPublication>("maven") {
            artifactId = "yutori-bridge-java"
            version = System.getenv("VERSION")
            description = "Kotlin Multiplatform library"

            pom {
                name = "Yutori-Bridge-Java"
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
}