FROM openjdk:8-jdk-alpine
COPY target/spring-demo-*.jar app.jar
EXPOSE 8080
ENTRYPOINT ["java","-Djava.security.egd=file:/dev/./urandom","-jar","/app.jar"]