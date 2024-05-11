plugins {
    id("com.android.library")
    id("org.jetbrains.kotlin.android")
    id("maven-publish")
}

android {
    namespace = "com.example.jitpacktest"
    compileSdk = 34

    defaultConfig {
//        applicationId = "com.example.jitpacktest"
        minSdk = 24
//        targetSdk = 34
//        versionCode = 1
//        versionName = "1.0"

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
    compileOptions {
        sourceCompatibility = JavaVersion.VERSION_17
        targetCompatibility = JavaVersion.VERSION_17
    }
    kotlinOptions {
        jvmTarget = "17"
    }
}

dependencies {
//    implementation(fileTree(mapOf("dir" to "libs", "include" to listOf("*.jar","*.aar"))))

//    implementation(files("libs/deptrumSDK.aar"))

    implementation("androidx.core:core-ktx:1.13.1")
    implementation("androidx.appcompat:appcompat:1.6.1")
    implementation("com.google.android.material:material:1.12.0")
    testImplementation("junit:junit:4.13.2")
    androidTestImplementation("androidx.test.ext:junit:1.1.5")
    androidTestImplementation("androidx.test.espresso:espresso-core:3.5.1")
}

group = "com.github.wzh-gpu"
version = "1.0.0"

afterEvaluate {
    publishing {
        publications {
            // Creates a Maven publication called "release".
            create<MavenPublication>("release") {
                // Applies the component for the release build variant.\
                // from(components["release"])
                // You can then customize attributes of the publication as shown below.
                groupId = (group.toString())
                artifactId = "deptrumSDK"
                version = version

            }

            create<MavenPublication>("aarFaceSDK") {
                groupId = group.toString()
                artifactId = "facesdk"
                version = "1.0.0"

                afterEvaluate {
                    // 指定 AAR 文件的路径
                    artifact("${projectDir}/libs/FaceSDK_8.1_20230216-release.aar")
                }
            }
        }


    }
}

