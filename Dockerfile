FROM openjdk:17-jdk-alpine
WORKDIR /app
COPY target/BookManagementSystem.jar /app/BookManagementSystem.jar
EXPOSE 8080
CMD ["java", "-jar", "/app/BookManagementSystem.jar"]
MAINTAINER Mohamed LAKEHAL