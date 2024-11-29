plugins {
    kotlin("jvm") version "2.0.21" apply false
}

subprojects {
    apply(plugin = "maven-publish")

    group = "cn.yurin.yutori.bridge"

    configure<PublishingExtension> {
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
    }
}