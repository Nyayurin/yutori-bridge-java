plugins {
    kotlin("multiplatform") version "2.0.21"
    alias(libs.plugins.android.library)
}

kotlin {
    jvmToolchain(8)

    jvm()

    androidTarget {
        publishLibraryVariants("release", "debug")
    }

    sourceSets {
        commonMain.dependencies {
            api(libs.yutori)
        }
    }
}

android {
    namespace = "cn.yurin.yutori.bridge.java"
    compileSdk = 34

    defaultConfig {
        minSdk = 24
    }
    compileOptions {
        sourceCompatibility = JavaVersion.VERSION_1_8
        targetCompatibility = JavaVersion.VERSION_1_8
    }
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