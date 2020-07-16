package com.ashetm.project.kafka.consumers;

import com.ashetm.project.kafka.enums.KafkaTopic;
import com.ashetm.project.kafka.models.Message;
import org.apache.kafka.clients.consumer.ConsumerRecord;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Profile;
import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.messaging.simp.SimpMessagingTemplate;
import org.springframework.stereotype.Service;

@Service
@Profile("WITH_CONSUMER")
public class KafkaConsumerImpl implements KafkaConsumer<String, Message> {

    @Value("${custom.kafka.topic.1}")
    private String topic1;

    @Value("${custom.kafka.topic.2}")
    private String topic2;

    @Autowired
    private SimpMessagingTemplate singleMessagingTemplate;

    @KafkaListener(topics = "${custom.kafka.topic.1}", groupId = "${custom.kafka.group.id}")
    public void consumeTopic1(ConsumerRecord<String, Message> message) {
        String topic = KafkaTopic.TOPIC_1.getTopic();
        System.out.println("From topic: " + topic + ", Consumed message: " + message.toString());
        singleMessagingTemplate.convertAndSend("/topic/" + topic1 + "/message", message.value());
    }

    @KafkaListener(topics = "${custom.kafka.topic.2}", groupId = "${custom.kafka.group.id}")
    public void consumeTopic2(ConsumerRecord<String, Message> message) {
        String topic = KafkaTopic.TOPIC_1.getTopic();
        System.out.println("From topic: " + topic + ", Consumed message: " + message.toString());
        singleMessagingTemplate.convertAndSend("/topic/" + topic2 + "/message", message.value());
    }
    
}
