import org.jetbrains.compose.desktop.application.dsl.TargetFormat

plugins {
    kotlin("jvm")
    id("org.jetbrains.compose")
}

group = "com.example"
version = "1.0-SNAPSHOT"

repositories {
    mavenCentral()
    maven("https://maven.pkg.jetbrains.space/public/p/compose/dev")
    google()
}

dependencies {
    // Note, if you develop a library, you should use compose.desktop.common.
    // compose.desktop.currentOs should be used in launcher-sourceSet
    // (in a separate module for demo project and in testMain).
    // With compose.desktop.common you will also lose @Preview functionality
    implementation(compose.desktop.currentOs)
    implementation(fileTree("dir" to "libs", "include" to "*.jar"))
}

compose.desktop {
    application {
        mainClass = "MainKt"

        nativeDistributions {
            targetFormats(TargetFormat.Dmg, TargetFormat.Msi, TargetFormat.Deb)
            packageName = "reproducedError"
            packageVersion = "1.0.0"
            modules("java.compiler", "java.instrument" , "java.sql", "jdk.unsupported","java.naming","java.logging")
            appResourcesRootDir.set(project.layout.projectDirectory.dir("apk_template"))
            macOS {

                // a version only for the dmg package
                dmgPackageVersion = "1.2.1"

                dmgPackageBuildVersion = "1.2.1"

                bundleID = "com.example.reproducedError"
                signing {
                    sign.set(true)
                    identity.set("Cesar Gasca")
                }

            }
        }
    }
}
