FROM openjdk:11-jre-slim

ARG JAR_FILE=./build/libs/*-SNAPSHOT.jar

COPY ${JAR_FILE} library-app.jar

ENTRYPOINT ["java","-jar","/library-app.jar"]