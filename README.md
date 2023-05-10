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

## Kafka Connect (Connector)
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
    "schemas.enable": false,
    "flush.synchronously": true,
    "transforms": "timestampRouter",
    "transforms.timestampRouter.type": "org.apache.kafka.connect.transforms.TimestampRouter",
    "transforms.timestampRouter.topic.format": "${topic}-${timestamp}",
    "transforms.timestampRouter.timestamp.format": "yyyyMMdd"
  }
}'
```

## Elasticsearch (Template)
```shell
curl -X PUT http://localhost:9200/_index_template/aootb_template -H 'Content-Type: application/json' -d \
'{
    "index_patterns": [
        "com.company.*"
    ],
    "template": {
        "settings": {
            "number_of_shards": 1
        },
        "mappings": {
            "_source": {
                "enabled": true
            },
            "properties": {
                "headers": {
                    "type": "object",
                    "properties": {
                        "DATE": {
                            "type": "date",
                            "format": "EEE, dd MMM yyyy HH:mm:ss z||EEE, d MMM yyyy HH:mm:ss z"
                        },
                        "event-aggregate-id": {
                            "type": "integer"
                        },
                        "event-aggregate-type": {
                            "type": "keyword"
                        },
                        "event-type": {
                            "type": "keyword"
                        },
                        "hostname": {
                            "type": "keyword"
                        },
                        "message-id": {
                            "type": "keyword"
                        },
                        "request-uri": {
                            "type": "keyword"
                        },
                        "user-agent": {
                            "type": "keyword"
                        },
                        "x-app-version": {
                            "type": "version"
                        },
                        "x-callerip": {
                            "type": "ip"
                        },
                        "x-geoposition": {
                            "type": "geo_point"
                        },
                        "x-user-device-id": {
                            "type": "keyword"
                        }
                    }
                }
            }
        }
    }
}'
```

## Kibana (Dashboard)
```shell
#The "Atomic32OutOfTheBoxDashboards.ndjson" file is located in the root of the project

curl -X POST http://localhost:5601/api/saved_objects/_import?createNewCopies=true \
-H "kbn-xsrf: true" --form file=@Atomic32OutOfTheBoxDashboards.ndjson
```

## Bank Registration (API)
```shell
curl -X POST 'http://localhost:8066/customers/bank-client-data' \
-H 'x-callerip: 203.0.113.195' \
-H 'x-geoposition: 19.40423423, -99.0023423423' \
-H 'x-app-version: 1.0' \
-H 'x-user-device-id: 69e2ef62-f5e0-4a22-b741-cceb8793383e' \
-H 'Content-Type: application/json' \
-d \
'{
    "digitalBankId": "09870987",
    "clientId": 9876,
    "customerId": 1234,
    "bpId": "09809709"
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
