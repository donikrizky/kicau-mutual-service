FROM openjdk:8-jdk-alpine

COPY target/mutual-service-0.0.1-SNAPSHOT.jar /app/mutual-service.jar

CMD ["java", "-jar", "/app/mutual-service.jar"]