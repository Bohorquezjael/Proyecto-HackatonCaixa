FROM maven:3.9.9-eclipse-temurin-21 as build

WORKDIR /app

COPY ./message-service/pom.xml ./
COPY ./message-service/src ./src
COPY proto-definition ./proto-definition

# Build proto-definition
WORKDIR /app/proto-definition
RUN mvn clean install -DskipTests

# Build Java Project
WORKDIR /app
RUN mvn clean package -DskipTests

FROM openjdk:21-jdk-slim

WORKDIR /app

COPY --from=build /app/target/*.jar /app/message.jar

# Expose both: HTTP & gRPC
EXPOSE 8181 9696

ENTRYPOINT ["java", "-jar", "/app/message.jar"]