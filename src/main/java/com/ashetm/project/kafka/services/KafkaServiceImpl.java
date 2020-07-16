package com.ashetm.project.kafka.services;

import com.ashetm.project.kafka.producers.KafkaProducer;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Profile;
import org.springframework.stereotype.Service;

@Service
@Profile("WITH_PRODUCER")
public class KafkaServiceImpl<T> implements KafkaService<T> {

    @Autowired
    KafkaProducer<String, T> kafkaProducer;

    @Override
    public void send(String topic, T message) {
        this.kafkaProducer.send(topic, message);
    }
}
