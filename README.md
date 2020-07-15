
Add both profiles: 
* WITH_CONSUMER: for Kafka Consumer
* WITH_PRODUCER: for Kafka Producer with and RESTController endpoint for test

mvn spring-boot:run -Dspring.profiles.active=WITH_CONSUMER,WITH_PRODUCER
