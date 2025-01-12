plugins {
    alias(libs.plugins.kotlin.multiplatform)
    `maven-publish`
}

group = "dev.myshkouski.kotlin"
version = "0.1.3"

repositories {
    mavenCentral()
}

kotlin {
    jvmToolchain(8)

    jvm()
    js {
        binaries.executable()
        nodejs {
            testTask {
                useMocha()
            }
        }
        useEsModules()
        generateTypeScriptDefinitions()
    }
    linuxX64()
    linuxArm64()
    macosX64()
    macosArm64()
    iosX64()
    iosArm64()
    watchosX64()
    watchosArm32()
    watchosArm64()
    tvosX64()
    tvosArm64()

    sourceSets {
        commonTest.dependencies {
            implementation(kotlin("test"))
        }
        jsMain.dependencies {
            implementation(libs.kotlin.wrappers.js)
        }
    }
}
