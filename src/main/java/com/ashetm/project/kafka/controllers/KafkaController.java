package com.ashetm.project.kafka.controllers;

import com.ashetm.project.kafka.dto.KafkaResponseView;
import com.ashetm.project.kafka.models.Message;
import org.springframework.http.ResponseEntity;

public interface KafkaController {

    ResponseEntity<KafkaResponseView> produce(String topic, Message body);

}
