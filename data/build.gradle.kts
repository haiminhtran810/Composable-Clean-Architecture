plugins {
    id(Plugins.LIBRARY)
    id(Plugins.JETBRAINS_KOTLIN)
}

android {
    namespace = "com.home.data"
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
            buildConfigField(
                "String",
                "BASE_API_URL",
                "\"https://api.openweathermap.org/data/2.5/\""
            )
            buildConfigField("String", "WEATHER_APP_ID", "\"7315d981fa54392d62c44626a5a947e8\"")
        }

        create(Builds.Flavors.PRD) {
            dimension = Builds.SHARED_DIMENSION
            buildConfigField(
                "String",
                "BASE_API_URL",
                "\"https://api.openweathermap.org/data/2.5/\""
            )
            buildConfigField("String", "WEATHER_APP_ID", "\"7315d981fa54392d62c44626a5a947e8\"")
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

    implementation(project(Modules.DOMAIN))

    implementation(Libs.AndroidX.CORE_KTX)
    implementation(Libs.AndroidX.APPCOMPAT)
    implementation(Libs.AndroidX.MATERIAL)
    testImplementation(Libs.Test.JUNIT)
    androidTestImplementation(Libs.Test.JUNIT_EXT)
    androidTestImplementation(Libs.Test.ESPRESSO_CORE)

    implementation(Libs.Room.KTX)
    implementation(Libs.Room.RUNTIME)
    annotationProcessor(Libs.Room.COMPILER)

    implementation(Libs.Retrofit.CORE)
    implementation(Libs.Retrofit.CONVERTER)
    implementation(Libs.Retrofit.MOCK)

    implementation(Libs.OkHttp.OKHTTP)
    implementation(Libs.OkHttp.LOGGING)

    implementation(Libs.Koin.KOIN)
    implementation(Libs.Log.TIMBER)

}