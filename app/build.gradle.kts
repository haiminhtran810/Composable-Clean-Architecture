plugins {
    id(Plugins.APPLICATION)
    id(Plugins.JETBRAINS_KOTLIN)
}

android {
    namespace = Configs.NAMESPACE
    compileSdk = Configs.COMPILE_SDK

    defaultConfig {
        applicationId = Configs.APP_ID
        minSdk = Configs.MIN_SDK
        targetSdk = Configs.TARGET_SDK
        versionCode = Configs.VERSION_CODE
        versionName = Configs.VERSION_NAME

        testInstrumentationRunner = Configs.ANDROID_JUNIT_RUNNER

        vectorDrawables {
            useSupportLibrary = true
        }
    }

    buildTypes {
        getByName(Builds.Release.name) {
            isMinifyEnabled = Builds.Release.isMinifyEnabled
            isShrinkResources = Builds.Release.isShrinkResources
            isDebuggable = Builds.Release.isDebuggable
            proguardFiles(
                getDefaultProguardFile(Configs.PROGUARD_ANDROID_OPTIMIZE),
                Configs.PROGUARD_RULES
            )
        }
        getByName(Builds.Debug.name) {
            isMinifyEnabled = Builds.Debug.isMinifyEnabled
            isShrinkResources = Builds.Debug.isShrinkResources
            isDebuggable = Builds.Debug.isDebuggable
            proguardFiles(
                getDefaultProguardFile(Configs.PROGUARD_ANDROID_OPTIMIZE),
                Configs.PROGUARD_RULES
            )
        }
    }

    flavorDimensions += Builds.SHARED_DIMENSION
    productFlavors {
        create(Builds.Flavors.DEV) {
            applicationIdSuffix = ".${Builds.Flavors.DEV}"
            dimension = Builds.SHARED_DIMENSION
        }

        create(Builds.Flavors.PRD) {
            dimension = Builds.SHARED_DIMENSION
        }
    }

    compileOptions {
        sourceCompatibility = JavaVersion.VERSION_1_8
        targetCompatibility = JavaVersion.VERSION_1_8
    }

    kotlinOptions {
        jvmTarget = JavaVersion.VERSION_1_8.toString()
    }

    buildFeatures {
        compose = true
    }

    composeOptions {
        kotlinCompilerExtensionVersion = Versions.COMPOSE_COMPILER
    }

    packaging {
        resources {
            excludes += "/META-INF/{AL2.0,LGPL2.1}"
        }
    }
}

dependencies {
    implementation(Libs.AndroidX.CORE_KTX)
    implementation(Libs.AndroidX.LIFECYCLE_RUNTIME_KTX)
    implementation(Libs.AndroidX.ACTIVITY_COMPOSE)
    implementation(platform(Libs.AndroidX.COMPOSE_BOOM))
    implementation(Libs.Compose.UI)
    implementation(Libs.Compose.UI_GRAPHICS)
    implementation(Libs.Compose.UI_TOOLING_PREVIEW)
    implementation(Libs.Compose.UI_MATERIAL)
    debugImplementation(Libs.Compose.UI_TOOLING)
    debugImplementation(Libs.Compose.UI_TEST_MANIFEST)
    testImplementation(Libs.Test.JUNIT_EXT)
    androidTestImplementation(Libs.Test.JUNIT)
    androidTestImplementation(Libs.Test.ESPRESSO_CORE)
    androidTestImplementation(platform(Libs.AndroidX.COMPOSE_BOOM))
    androidTestImplementation(Libs.Test.COMPOSE_UI_JUNIT)
}