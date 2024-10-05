plugins {
    id(Plugins.LIBRARY)
    id(Plugins.JETBRAINS_KOTLIN)
}

android {
    namespace = "com.home.domain"
    compileSdk = Configs.COMPILE_SDK

    defaultConfig {
        minSdk = Configs.MIN_SDK

        testInstrumentationRunner = Configs.ANDROID_JUNIT_RUNNER
        consumerProguardFiles(Configs.CONSUMER_RULES)
    }

    buildTypes {
        release {
            isMinifyEnabled = false
            proguardFiles(
                getDefaultProguardFile(Configs.PROGUARD_ANDROID_OPTIMIZE),
                Configs.PROGUARD_RULES
            )
        }
    }

    flavorDimensions += Builds.SHARED_DIMENSION
    productFlavors {
        create(Builds.Flavors.DEV) {
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
}

dependencies {

    implementation(Libs.AndroidX.CORE_KTX)
    implementation(Libs.AndroidX.APPCOMPAT)
    implementation(Libs.AndroidX.MATERIAL)
    testImplementation(Libs.Test.JUNIT)
    androidTestImplementation(Libs.Test.JUNIT_EXT)
    androidTestImplementation(Libs.Test.ESPRESSO_CORE)

    implementation(Libs.Retrofit.CONVERTER)
}