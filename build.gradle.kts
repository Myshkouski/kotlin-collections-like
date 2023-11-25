plugins {
    kotlin("multiplatform") version "1.9.21"
}

group = "dev.myshkouski.kotlin"
version = "0.1.0"

repositories {
    mavenCentral()
}

kotlin {
    jvm {
        jvmToolchain(8)
    }

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

    sourceSets {
        commonTest {
            dependencies {
                implementation(kotlin("test"))
            }
        }

        jsMain {
            dependencies {
                implementation("org.jetbrains.kotlin-wrappers:kotlin-js:1.0.0-pre.647")
            }
        }
    }
}
