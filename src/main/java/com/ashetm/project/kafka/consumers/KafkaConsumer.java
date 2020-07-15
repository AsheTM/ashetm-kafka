package com.ashetm.project.kafka.consumers;

import org.apache.kafka.clients.consumer.ConsumerRecord;

public interface KafkaConsumer<T, U> {

    void consumeTopic1(ConsumerRecord<T, U> message);
    void consumeTopic2(ConsumerRecord<T, U> message);

}
