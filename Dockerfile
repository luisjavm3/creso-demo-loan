FROM openjdk:17-jdk-alpine
WORKDIR /app
COPY ./target/loan-service.jar .
EXPOSE 8000
CMD [ "java", "-jar", "loan-service.jar" ]