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

## Kafka Connect Service
```shell
docker exec -it kafka-connect bash
curl -X POST http://localhost:8083/connectors -H 'Content-Type: application/json' -d \
'{
  "name": "ElasticSearchSinkConnector",
  "config": {
    "connector.class": "io.confluent.connect.elasticsearch.ElasticsearchSinkConnector",
    "tasks.max": 1,
    "topics": "'$BANKREGISTRATION_SINK_TOPIC'",
    "connection.url": "'$BANKREGISTRATION_SINK_URL'",
    "type.name": "_doc",
    "name": "ElasticSearchSinkConnector",
    "key.converter": "org.apache.kafka.connect.storage.StringConverter",
    "key.converter.schemas.enable": false,
    "value.converter": "org.apache.kafka.connect.json.JsonConverter",
    "value.converter.schemas.enable": false,
    "key.ignore": true,
    "schema.ignore": true,
    "schemas.enable": false
  }
}'
```

## Query's
```shell
#Kafka Connect
http://localhost:8083/connectors?expand=info&expand=status

#Kafka
./kafka-topics --list --bootstrap-server localhost:9092

./kafka-console-consumer --bootstrap-server localhost:9092 --topic com.company.bankregistration.service.model.entities.BankCustomerData --from-beginning

#Elasticsearch
http://localhost:9200/com.company.bankregistration.service.model.entities.bankcustomerdata/_search

#Kibana
GET com.company.bankregistration.service.model.entities.bankcustomerdata/_search
{
  "query": {
    "match_phrase": {
      "headers.event-aggregate-id": {
        "query": 1
      }
    }
  }
}
```

## Destroy all components
```shell
docker-compose down -v
```
