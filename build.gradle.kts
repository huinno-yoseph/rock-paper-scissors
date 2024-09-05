java {
    sourceCompatibility = JavaVersion.VERSION_17
    targetCompatibility = JavaVersion.VERSION_17
}

plugins {
    id("org.springframework.boot") version "3.0.0"
    id("io.spring.dependency-management") version "1.0.11.RELEASE"
    kotlin("jvm") version "1.9.0"
    kotlin("plugin.spring") version "1.9.0"
}

group = "com.example"
version = "1.0-SNAPSHOT"
java.sourceCompatibility = JavaVersion.VERSION_17

repositories {
    mavenCentral()
}

dependencies {
    implementation("org.springframework.boot:spring-boot-starter-web")  // Spring Boot Starter 의존성
    testImplementation("org.springframework.boot:spring-boot-starter-test")
}

tasks.withType<Jar> {
    manifest {
        attributes["Main-Class"] = "com.example.game.GameApplication"  // 메인 클래스 지정
    }
}

tasks.withType<Jar> {
    enabled = false  // 기본 JAR 빌드를 비활성화
}

tasks.withType<org.springframework.boot.gradle.tasks.bundling.BootJar> {
    enabled = true  // Fat JAR 빌드를 활성화
}

tasks.withType<Test> {
    useJUnitPlatform()
}