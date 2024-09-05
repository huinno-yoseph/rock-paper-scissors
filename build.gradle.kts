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
    // Spring Boot 웹 애플리케이션을 위한 기본 스타터
    implementation("org.springframework.boot:spring-boot-starter-web")

    // 테스트를 위한 의존성
    testImplementation("org.springframework.boot:spring-boot-starter-test")
}

tasks.withType<Jar> {
    manifest {
        attributes["Main-Class"] = "com.example.game.GameApplication"  // 메인 클래스 지정
    }
}

tasks.withType<org.springframework.boot.gradle.tasks.bundling.BootJar> {
    enabled = true  // Fat JAR 빌드를 활성화
}

tasks.withType<Test> {
    useJUnitPlatform()
}