object Libs {
    object AndroidX {
        const val CORE_KTX = "androidx.core:core-ktx:${Versions.KOTLIN}"
        const val LIFECYCLE_RUNTIME_KTX =
            "androidx.lifecycle:lifecycle-runtime-ktx:${Versions.LIFECYCLE_RUNTIME_KTX}"
        const val ACTIVITY_COMPOSE =
            "androidx.activity:activity-compose:${Versions.ACTIVITY_COMPOSE}"
        const val COMPOSE_BOOM = "androidx.compose:compose-bom:${Versions.COMPOSE_BOOM}"
        const val APPCOMPAT="androidx.appcompat:appcompat:1.6.1"
        const val MATERIAL="com.google.android.material:material:1.8.0"
    }

    object Kotlin {
        const val VIEW_MODEL =
            "androidx.lifecycle:lifecycle-viewmodel-compose:${Versions.VIEW_MODEL}"


    }

    object Test {
        const val JUNIT_EXT = "androidx.test.ext:junit:${Versions.JUNIT_EXT}"
        const val JUNIT = "junit:junit:${Versions.JUNIT}"
        const val ESPRESSO_CORE = "androidx.test.espresso:espresso-core:${Versions.ESPRESSO_CORE}"
        const val COMPOSE_UI_JUNIT = "androidx.compose.ui:ui-test-junit4"
    }

    object Compose {
        const val UI = "androidx.compose.ui:ui"
        const val UI_GRAPHICS = "androidx.compose.ui:ui-graphics"
        const val UI_TOOLING_PREVIEW = "androidx.compose.ui:ui-tooling-preview"
        const val UI_MATERIAL = "androidx.compose.material3:material3"
        const val UI_TOOLING = "androidx.compose.ui:ui-tooling"
        const val UI_TEST_MANIFEST = "androidx.compose.ui:ui-test-manifest"
    }
}