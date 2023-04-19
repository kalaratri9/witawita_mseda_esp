# What I talk about when I talk about...
# Microservices and Event Driven Architectures and Event Streaming Processing

This training requires some components to be run before executing any service.

## Java Components

Apache Maven and Java Development Kit (JDK) 11 are required to build the components

```shell
cd workspace/domain-events-commons
mvn clean install
cd ../bankregistration-api
mvn clean package
cd ../oath-api
mvn clean package
```

## Run components
```shell
docker-compose up -d
```

## EVENTUATE CDC Service
```shell
docker logs cdc-service
```

## Destroy all components
```shell
docker-compose down -v
```
