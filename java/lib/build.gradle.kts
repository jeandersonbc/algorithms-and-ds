plugins {
    `java-library`
    alias(libs.plugins.spotless)
}

repositories {
    mavenCentral()
}

dependencies {
    testImplementation(libs.junit.jupiter)

    testRuntimeOnly("org.junit.platform:junit-platform-launcher")
}

java {
    toolchain {
        languageVersion = JavaLanguageVersion.of(21)
    }
}

spotless {
    java {
        palantirJavaFormat()
    }
}

tasks.named("check") {
    dependsOn("spotlessApply")
}

tasks.named<Test>("test") {
    useJUnitPlatform()
}
