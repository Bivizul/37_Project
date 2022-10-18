object Deps {

    object Versions {
        const val compileSdk = 33
        const val minSdk = 24
        const val targetSdk = compileSdk
        const val composeJetbrains = "1.2.0-alpha01-dev753"
        const val kotlin = "1.7.0"
        const val agp = "7.3.1"
        const val onesignal = "0.14.0"
        const val composeCompiler = "1.2.0"
    }

    object JetBrains {

        object Serialization {
            private val VERSION get() = "1.4.0"
            val serializationJson get() = "org.jetbrains.kotlinx:kotlinx-serialization-json:$VERSION"
        }

        object KotlinCoroutines {
            private val VERSION get() = "1.6.4"
            val android get() = "org.jetbrains.kotlinx:kotlinx-coroutines-android:$VERSION"
            val core get() = "org.jetbrains.kotlinx:kotlinx-coroutines-core:$VERSION"
        }

    }

    object AndroidX {
        const val appCompat = "androidx.appcompat:appcompat:1.5.1"
        const val core_ktx = "androidx.core:core-ktx:1.8.0"
        const val activityCompose = "androidx.activity:activity-compose:1.5.1"
    }

    object ArkIvanov {
        object Decompose {
            private const val VERSION = "1.0.0-alpha-04-native-compose"
            const val decompose = "com.arkivanov.decompose:decompose:$VERSION"
            const val extensionsComposeJetbrains =
                "com.arkivanov.decompose:extensions-compose-jetbrains:$VERSION"
            const val extensionsAndroid = "com.arkivanov.decompose:extensions-android:$VERSION"
        }

        object Essenty {
            private const val VERSION = "0.5.2"
            const val lifecycle = "com.arkivanov.essenty:lifecycle:$VERSION"
        }
    }

    object Kmp {
        object Ktor {
            private const val VERSION = "2.1.0"
            const val core = "io.ktor:ktor-client-core:$VERSION"
            const val logging = "io.ktor:ktor-client-logging:$VERSION"
            const val cio = "io.ktor:ktor-client-cio:$VERSION"
            const val negotiation = "io.ktor:ktor-client-content-negotiation:$VERSION"
            const val json = "io.ktor:ktor-serialization-kotlinx-json:$VERSION"
        }

        object Util {
            const val onesignal = "com.onesignal:OneSignal:4.8.2"
            const val coil = "io.coil-kt:coil-compose:2.2.1"
        }
    }
}