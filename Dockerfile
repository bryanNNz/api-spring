# MAVEN BUILD #
FROM maven:3.6.3-openjdk-11 AS maven_build

COPY src /app/src

COPY pom.xml /app

RUN mvn -f /app/pom.xml clean package


# API BUILD #
FROM openjdk

WORKDIR /app

COPY --from=maven_build /app/target/ApiSpring-0.0.1-SNAPSHOT.jar /app/api-spring.jar

ENTRYPOINT [ "java", "-jar", "api-spring.jar" ]