package com.ashetm.project.kafka.producers;

import com.ashetm.project.kafka.enums.KafkaTopic;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Profile;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.stereotype.Service;

@Service
@Profile("WITH_PRODUCER")
public class KafkaProducerImpl<T, U> implements KafkaProducer<T, U> {

    @Autowired
    private KafkaTemplate<T, U> kafkaTemplate;

    public void send(String topic, U message) {
        this.kafkaTemplate.send(topic, message);
    }

    public void send(String topic, T key, U value) {
        this.kafkaTemplate.send(topic, key, value);
    }

    public void send(KafkaTopic topic, U message) {
        this.send(topic.getTopic(), message);
    }

    public void send(KafkaTopic topic, T key, U value) {
        this.send(topic.getTopic(), key, value);
    }

}
