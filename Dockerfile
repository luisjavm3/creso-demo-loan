FROM openjdk:17-jdk-alpine
WORKDIR /app
COPY /var/lib/jenkins/workspace/creso-demo-loan/target/loan-service.jar .
EXPOSE 8000
CMD [ "java", "-jar", "loan-service.jar" ]