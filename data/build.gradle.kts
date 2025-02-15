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
                "\"https://api.themoviedb.org/3/\""
            )
            buildConfigField("String", "MOVIE_APP_ID", "\"3e047b2cc8fc38537ee7b3e6f547e53c\"")
            buildConfigField("String", "MOVIE_IMAGE_SMALL", "\"https://image.tmdb.org/t/p/w200\"")
            buildConfigField("String", "MOVIE_IMAGE_LARGE", "\"https://image.tmdb.org/t/p/w500\"")
            buildConfigField(
                "String",
                "MOVIE_IMAGE_ORIGINAL",
                "\"https://image.tmdb.org/t/p/original\""
            )
        }

        create(Builds.Flavors.PRD) {
            dimension = Builds.SHARED_DIMENSION
            buildConfigField(
                "String",
                "BASE_API_URL",
                "\"https://api.themoviedb.org/3/\""
            )
            buildConfigField("String", "MOVIE_APP_ID", "\"3e047b2cc8fc38537ee7b3e6f547e53c\"")
            buildConfigField("String", "MOVIE_IMAGE_SMALL", "\"https://image.tmdb.org/t/p/w200\"")
            buildConfigField("String", "MOVIE_IMAGE_LARGE", "\"https://image.tmdb.org/t/p/w500\"")
            buildConfigField(
                "String",
                "MOVIE_IMAGE_ORIGINAL",
                "\"https://image.tmdb.org/t/p/original\""
            )
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
        buildConfig = true
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