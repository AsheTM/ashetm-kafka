Before start the Spring Boot App:

Don't forget to install Apache Kafka, and launch: 
Kafka Zookeeper: 
- .\bin\windows\zookeeper-server-start.bat .\config\zookeeper.properties
Kafka Server: 
- .\bin\windows\kafka-server-start.bat .\config\server.properties
To create 2 topics: 
- .\bin\windows\kafka-topics.bat --create --zookeeper localhost:2181 --replication-factor 1 --partitions 1 --topic TOPIC_1
- .\bin\windows\kafka-topics.bat --create --zookeeper localhost:2181 --replication-factor 1 --partitions 1 --topic TOPIC_2
(Optional) Kafka Consumer, if WITH_CONSUMER profile not provided
- .\bin\windows\kafka-console-consumer.bat --bootstrap-server localhost:9092 --topic TOPIC_1 --from-beginning
- .\bin\windows\kafka-console-consumer.bat --bootstrap-server localhost:9092 --topic TOPIC_2 --from-beginning
(Optional) Kafka Producer, if WITH_PRODUCER profile not provided
- .\bin\windows\kafka-console-producer.bat --bootstrap-server localhost:9092 --topic TOPIC_1
- .\bin\windows\kafka-console-producer.bat --bootstrap-server localhost:9092 --topic TOPIC_2

Add both profiles: 
* WITH_CONSUMER: for Kafka Consumer
* WITH_PRODUCER: for Kafka Producer with and RESTController endpoint for test

mvn spring-boot:run -Dspring.profiles.active=WITH_CONSUMER,WITH_PRODUCER
