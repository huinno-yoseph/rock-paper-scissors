plugins {
    id("org.springframework.boot") version "3.0.0" // 최신 버전으로 업데이트
    id("io.spring.dependency-management") version "1.1.0" // 최신 버전으로 업데이트
    kotlin("jvm") version "1.9.0" // Kotlin 1.9.0 사용
    kotlin("plugin.spring") version "1.9.0"
}

group = "com.example"
version = "1.0-SNAPSHOT"
java.sourceCompatibility = JavaVersion.VERSION_17 // Java 17 이상 사용 권장

repositories {
    mavenCentral()
}

dependencies {
    implementation("org.springframework.boot:spring-boot-starter-web")
    testImplementation("org.springframework.boot:spring-boot-starter-test")
}

tasks.withType<Test> {
    useJUnitPlatform()
}

tasks.withType<Jar> {
    archiveFileName.set("rock-paper-scissors.jar")
}