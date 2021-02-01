# API BUILD
FROM openjdk

WORKDIR /app

COPY /target/ApiSpring-0.0.1-SNAPSHOT.jar /app/api-spring.jar

ENTRYPOINT [ "java", "-jar", "api-spring.jar" ]