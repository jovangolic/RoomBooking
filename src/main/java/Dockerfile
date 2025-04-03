FROM maven:3.9.0-eclipse-temurin-17 AS builder
WORKDIR /app
COPY . .
RUN mvn clean package -DskipTests

# Koristi JDK za pokretanje aplikacije
FROM eclipse-temurin:17-jdk
WORKDIR /app
COPY --from=builder /app/target/RoomBooking-0.0.1-SNAPSHOT.jar app.jar
ENTRYPOINT ["java", "-jar", "app.jar"]