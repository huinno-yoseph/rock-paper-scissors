java {
    sourceCompatibility = JavaVersion.VERSION_11  // Java 11 사용
    targetCompatibility = JavaVersion.VERSION_11
}

plugins {
    id("org.springframework.boot") version "2.7.0"  // Spring Boot 2.7.x로 버전 낮춤
    id("io.spring.dependency-management") version "1.0.11.RELEASE"
    kotlin("jvm") version "1.6.21"
    kotlin("plugin.spring") version "1.6.21"
}

group = "com.example"
version = "1.0-SNAPSHOT"

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