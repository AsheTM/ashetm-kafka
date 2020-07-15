package com.ashetm.project.kafka.consumers;

import com.ashetm.project.kafka.enums.KafkaTopic;
import org.apache.kafka.clients.consumer.ConsumerRecord;
import org.springframework.context.annotation.Profile;
import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.stereotype.Service;

@Service
@Profile("WITH_CONSUMER")
public class KafkaConsumerImpl implements KafkaConsumer<String, String> {

    @KafkaListener(topics = "${custom.kafka.topic.1}", groupId = "${custom.kafka.group.id}")
    public void consumeTopic1(ConsumerRecord<String, String> message) {
        String topic = KafkaTopic.TOPIC_1.getTopic();
        System.out.println("From topic: " + topic + ", Consumed message: " + message.toString());
    }

    @KafkaListener(topics = "${custom.kafka.topic.2}", groupId = "${custom.kafka.group.id}")
    public void consumeTopic2(ConsumerRecord<String, String> message) {
        String topic = KafkaTopic.TOPIC_1.getTopic();
        System.out.println("From topic: " + topic + ", Consumed message: " + message.toString());
    }
    
}
