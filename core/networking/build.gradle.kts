plugins {
    alias(libs.plugins.android.library)
    alias(libs.plugins.hilt.android)
    alias(libs.plugins.ksp)
}

android {
    namespace = "com.prueba.tecnica.core.networking"
    compileSdk {
        version = release(36) {
            minorApiLevel = 1
        }
    }

    defaultConfig {
        minSdk = 24

        testInstrumentationRunner = "androidx.test.runner.AndroidJUnitRunner"
        consumerProguardFiles("consumer-rules.pro")
    }

    buildTypes {
        release {
            isMinifyEnabled = false
            proguardFiles(
                getDefaultProguardFile("proguard-android-optimize.txt"),
                "proguard-rules.pro"
            )
        }
    }
    compileOptions {
        sourceCompatibility = JavaVersion.VERSION_11
        targetCompatibility = JavaVersion.VERSION_11
    }
    buildFeatures {
        buildConfig = true
    }
    flavorDimensions.add("type")

    val stringType = "String"
    productFlavors {
        create("dev") {
            buildConfigField(stringType, "BASE_URL", properties["URL_BASE_DEV"].toString())
        }
        create("qa") {
            buildConfigField(stringType, "BASE_URL", properties["URL_BASE_QA"].toString())
        }
        create("prod") {
            buildConfigField(stringType, "BASE_URL", properties["URL_BASE_PROD"].toString())
        }
    }
}

dependencies {
    implementation(project(":core:common"))
    implementation(project(":core:domain"))
    implementation(libs.coroutines.android)
    implementation(libs.javaxInject)
    implementation(libs.androidx.core.ktx)
    implementation(libs.androidx.appcompat)
    implementation(libs.material)
    debugImplementation(libs.chuckerteam.debug)
    implementation(libs.squareupRetrofit)
    implementation(libs.squareupRetrofitGson)
    implementation(libs.squareupOkhttpLoggingInterceptor)
    implementation(libs.squareupOkhttp)
    //hilt
    implementation(libs.hilt.android)
    ksp(libs.hilt.compiler)
}