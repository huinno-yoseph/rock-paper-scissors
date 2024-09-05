# Stage 1: Build the application
FROM gradle:8.10.0-jdk17 AS build
WORKDIR /app
COPY build.gradle.kts settings.gradle.kts ./
COPY src ./src
RUN gradle build --no-daemon

# Stage 2: Create the final image
FROM openjdk:17-jre-slim
WORKDIR /app
COPY --from=build /app/build/libs/rock-paper-scissors.jar /app/rock-paper-scissors.jar
EXPOSE 8080
ENTRYPOINT ["java", "-jar", "/app/rock-paper-scissors.jar"]