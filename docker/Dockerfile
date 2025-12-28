# ===== STAGE 1: BUILD =====
FROM maven:3.8.7-eclipse-temurin-8 AS build
WORKDIR /app

COPY pom.xml .
RUN mvn -B -DskipTests dependency:go-offline

COPY src ./src
RUN mvn -B -DskipTests clean package

# ===== STAGE 2: RUNTIME =====
FROM eclipse-temurin:8-jre
WORKDIR /app

# usuário não-root (boa prática)
RUN useradd -r -u 1001 appuser
USER appuser

COPY --from=build /app/target/*.jar app.jar

EXPOSE 8080

ENTRYPOINT ["java", \
  "-XX:MaxRAMPercentage=75.0", \
  "-XX:+UseG1GC", \
  "-jar", "/app/app.jar"]