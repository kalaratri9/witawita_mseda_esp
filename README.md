# What I talk about when I talk about...
# Microservices and Event Driven Architectures and Event Streaming Processing

This training requires some components to be run before executing any service.

```shell
docker-compose up -d
```

## RabbitMQ

```shell
docker exec some-rabbit rabbitmq-plugins enable rabbitmq_consistent_hash_exchange
docker restart some-rabbit
```

## MySQL

MySQL client or MySQL Workbench is requied for this component

```shell
mysql -u root -h 127.0.0.1 -P 3306 -p < sql_scripts/bank_registration.sql
mysql -u root -h 127.0.0.1 -P 3306 -p < sql_scripts/oath.sql
```

## EVENTUATE CDC Service
```shell
docker logs cdc-service
```

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

If you wish to run on console the components:

```shell
cd workspace
cd bankregistration-api
java -jar -Dspring.profiles.active=local target/bankregistration-api-1.0.0-SNAPSHOT.jar
```

```shell
cd workspace
cd oath-api
java -jar -Dspring.profiles.active=local target/oath-api-1.0.0-SNAPSHOT.jar
```


## Destroy all components
```shell
docker-compose down
```
