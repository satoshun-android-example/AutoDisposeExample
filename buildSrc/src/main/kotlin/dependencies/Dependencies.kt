package dependencies

const val COMPILE_SDK = 30
const val MIN_SDK = 14
const val TARGET_SDK = 30

const val VKOTLIN = "1.5.0"

const val ANDROID_PLUGIN = "com.android.tools.build:gradle:4.2.0"
const val KOTLIN_PLUGIN = "org.jetbrains.kotlin:kotlin-gradle-plugin:$VKOTLIN"
const val PUBLISH_PLUGIN = "com.vanniktech:gradle-maven-publish-plugin:0.11.1"

private const val VCOUROUTINE = "1.5.0-RC"
const val KOTLIN = "org.jetbrains.kotlin:kotlin-stdlib:$VKOTLIN"
const val COROUTINE = "org.jetbrains.kotlinx:kotlinx-coroutines-core:$VCOUROUTINE"
const val UI_COROUTINE = "org.jetbrains.kotlinx:kotlinx-coroutines-android:$VCOUROUTINE"

const val KTX = "androidx.core:core-ktx:1.3.2"

const val APPCOMPAT = "androidx.appcompat:appcompat:1.2.0"
const val CONSTRAINTLAYOUT = "androidx.constraintlayout:constraintlayout:2.0.4"
const val RECYCLER_VIEW = "androidx.recyclerview:recyclerview:1.2.0"

const val ACTIVITYX = "androidx.activity:activity-ktx:1.2.3"
const val FRAGMENTX = "androidx.fragment:fragment-ktx:1.3.3"

const val VIEWMODEL = "androidx.lifecycle:lifecycle-viewmodel-ktx:2.3.1"
const val LIVEDATA = "androidx.lifecycle:lifecycle-livedata:2.3.1"
const val LIFECYCLE = "androidx.lifecycle:lifecycle-common:2.3.1"
const val LIFECYCLE_RUNTIME = "androidx.lifecycle:lifecycle-runtime-ktx:2.3.1"
const val LIFECYCLE_COMPILER = "androidx.lifecycle:lifecycle-compiler:2.3.1"
const val LIFECYCLE_EXTENSIONS = "androidx.lifecycle:lifecycle-extensions:2.2.0"

const val JUNIT = "junit:junit:4.13.2"
const val TRUTH = "com.google.truth:truth:1.1.2"
const val TEST_RULES = "androidx.test:rules:1.3.0"
const val TEST_RUNNER = "androidx.test:runner:1.3.0"
const val TEST_CORE = "androidx.test:core-ktx:1.3.0"
const val TEST_JUNIT_RULES = "androidx.test.ext:junit-ktx:1.1.2"
const val ESPRESSO = "androidx.test.espresso:espresso-core:3.3.0"
const val ROBOLECTRIC = "org.robolectric:robolectric:4.5.1"
