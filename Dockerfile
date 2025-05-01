FROM openjdk:17-jdk-alpine AS builder
WORKDIR /app
COPY src ./src
COPY .mvn ./.mvn
COPY mvnw .
COPY pom.xml .
RUN ./mvnw clean package -DskipTests

FROM openjdk:17-jdk-alpine
WORKDIR /app
COPY --from=builder app/target/loan-service.jar .
EXPOSE 8000
CMD [ "java", "-jar", "loan-service.jar" ]