plugins {
    kotlin("multiplatform") version("1.9.22")
    `maven-publish`
}

group = "dev.myshkouski.kotlin"
version = "0.1.1"

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
            implementation("org.jetbrains.kotlin-wrappers:kotlin-js:1.0.0-pre.719")
        }
    }
}
