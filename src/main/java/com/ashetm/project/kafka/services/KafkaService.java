package com.ashetm.project.kafka.services;

public interface KafkaService<T> {

    void send(String topic, T message);

}
