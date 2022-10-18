plugins {
    id("com.android.application").version(Deps.Versions.agp).apply(false)
    id("com.android.library").version(Deps.Versions.agp).apply(false)
    id("org.jetbrains.compose").version(Deps.Versions.composeJetbrains).apply(false)
    id("com.onesignal.androidsdk.onesignal-gradle-plugin").version(Deps.Versions.onesignal).apply(false)
    kotlin("android").version(Deps.Versions.kotlin).apply(false)
    kotlin("multiplatform").version(Deps.Versions.kotlin).apply(false)
    kotlin("jvm").version(Deps.Versions.kotlin).apply(false)
    kotlin("plugin.serialization").version(Deps.Versions.kotlin).apply(false)
}

tasks.register("clean", Delete::class) {
    delete(rootProject.buildDir)
}