object Version {
    const val core = "1.9.0"
    const val appcompat = "1.5.1"
    const val androidMaterial = "1.6.1"
    const val constraintLayout = "2.1.4"

    const val testRunner = "1.5.2"

    const val testImplJunit = "4.13.2"
    const val androidTestImplJunit = "1.1.3"
    const val androidTestEspresso = "3.4.0"

    const val retrofit = "2.9.0"
    const val gsonConvertor = "2.9.0"
    const val okHttp = "4.9.0"
    const val scalerConvertor = "2.1.0"

    const val kotlinCoroutines = "1.6.1"

    const val coroutineLifecycleScope = "2.5.1"

    const val glide = "4.12.0"

    const val viewModelDeligate = "1.6.0"

    const val dagger = "2.44"
    const val hiltCompiler = "1.0.0"
    const val hiltComposeNavigation = "1.0.0"

    const val roomVersion = "2.4.3"

    const val swipeRefresh = "1.1.0"

    const val lottieAnimations = "3.4.2"

    // compose
    const val composeUiVersion = "1.3.3"
    const val composeActivity = "1.6.1"
    const val composeMaterial = "1.3.1"

    const val composeNavigation = "2.6.0-alpha05"

    const val coilImageLoading = "2.2.2"

    // testImplementation versions
    const val kotlinxCoroutine = "1.6.4"
    const val turbine = "0.12.1"
    const val mockito = "3.9.0"
    const val mockitoKotlin = "2.0.0"
    const val mockitoInline = "2.25.0"

    // dagger hilt testing
    const val daggerHiltTestImpl = "2.44"
    const val daggerHiltAndroidTestImpl = "2.44"
}

object Deps {
    const val core = "androidx.core:core-ktx:${Version.core}"
    const val appCompat = "androidx.appcompat:appcompat:${Version.appcompat}"
    const val androidMaterial = "com.google.android.material:material:${Version.androidMaterial}"
    const val constraintLayout =
        "androidx.constraintlayout:constraintlayout:${Version.constraintLayout}"

    // testing
    const val testRunner = "androidx.test:runner:${Version.testRunner}"
}

object DaggerHilt {
    const val hilt = "com.google.dagger:hilt-android:${Version.dagger}"
    const val hiltAndroidCompiler = "com.google.dagger:hilt-android-compiler:${Version.dagger}"
    const val hiltCompiler = "com.google.dagger:hilt-compiler:${Version.dagger}"
    const val hiltComposeNavigation =
        "androidx.hilt:hilt-navigation-compose:${Version.hiltComposeNavigation}"
}
