FROM maven:3.9.9-eclipse-temurin-21 as build

WORKDIR /app

COPY ./frontend-grpc-service/pom.xml ./
COPY ./frontend-grpc-service/src ./src
COPY proto-definition ./proto-definition

# Build proto-definition
WORKDIR /app/proto-definition
RUN mvn clean install -DskipTests

# Build Java Project
WORKDIR /app
RUN mvn clean package -DskipTests

FROM openjdk:21-jdk-slim

WORKDIR /app

COPY --from=build /app/target/*.jar /app/front.jar

# Expose both: HTTP & gRPC
EXPOSE 8031 3030

ENTRYPOINT ["java", "-jar", "/app/front.jar"]