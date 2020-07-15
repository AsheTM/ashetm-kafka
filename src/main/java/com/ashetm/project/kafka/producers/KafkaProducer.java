package com.ashetm.project.kafka.producers;

import com.ashetm.project.kafka.enums.KafkaTopic;

public interface KafkaProducer<T, U> {

    void send(KafkaTopic topic, U message);
    void send(KafkaTopic topic, T key, U value);
    void send(String topic, U message);
    void send(String topic, T key, U value);

}
