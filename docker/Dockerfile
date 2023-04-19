FROM openjdk:11.0.16-jre-slim-bullseye

WORKDIR /opt

COPY ./workspace/bankregistration-api/src/main/resources/application.yml ./bank/
COPY ./workspace/bankregistration-api/target/*.jar ./bank/app.jar

COPY ./workspace/oath-api/src/main/resources/application.yml ./oath/
COPY ./workspace/oath-api/target/*.jar ./oath/app.jar
