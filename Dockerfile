FROM openjdk:21-slim
COPY target/*.jar mooney-s.jar
ENTRYPOINT ["java", "-jar", "/mooney-s.jar"]
