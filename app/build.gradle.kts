plugins {
    alias(libs.plugins.android.application)
    id("kotlin-kapt")
    id("com.google.dagger.hilt.android")
    id("androidx.navigation.safeargs")
    alias(libs.plugins.google.gms.google.services)
    alias(libs.plugins.googleAndroidLibrariesMapsplatformSecretsGradlePlugin)
}

android {
    namespace = "com.aiyu.furniture"
    compileSdk = 36

    defaultConfig {
        applicationId = "com.aiyu.furniture"
        minSdk = 28
        targetSdk = 36
        versionCode = 1
        versionName = "1.0"

        testInstrumentationRunner = "androidx.test.runner.AndroidJUnitRunner"
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
    buildFeatures {
        viewBinding = true
        buildConfig = true
    }
    compileOptions {
        sourceCompatibility = JavaVersion.VERSION_11
        targetCompatibility = JavaVersion.VERSION_11
    }
}

dependencies {

    implementation(libs.appcompat)
    implementation(libs.material)
    implementation(libs.constraintlayout)
    implementation(libs.activity.v160alpha05)

    implementation(libs.navigation.fragment)
    implementation(libs.navigation.ui)

    implementation(libs.hilt.android)
    implementation(libs.play.services.auth)
    annotationProcessor(libs.hilt.android.compiler)

    implementation(libs.firebase.auth)
    implementation(libs.credentials)
    implementation(libs.credentials.play.services.auth)
    implementation(libs.googleid)
    implementation(libs.firebase.firestore)

    implementation(libs.glide)

    implementation(libs.json)
    implementation(libs.lifecycle.livedata.ktx)
}

kapt {
    correctErrorTypes = true
}
