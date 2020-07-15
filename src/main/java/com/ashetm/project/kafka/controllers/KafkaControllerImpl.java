package com.ashetm.project.kafka.controllers;

import com.ashetm.project.kafka.dto.KafkaResponseView;
import com.ashetm.project.kafka.enums.KafkaTopic;
import com.ashetm.project.kafka.services.KafkaService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Profile;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/kafka")
@Profile("WITH_PRODUCER")
public class KafkaControllerImpl implements KafkaController {

    @Autowired
    KafkaService kafkaService;

    @PostMapping("/{topic}")
    @Override
    public ResponseEntity<KafkaResponseView> produce(@PathVariable String topic, @RequestBody String body) {
        if(body.equals(null))
            return ResponseEntity
                    .status(HttpStatus.BAD_REQUEST)
                    .body(KafkaResponseView.to(false));

        if(!KafkaTopic.exists(topic))
            return ResponseEntity
                    .status(HttpStatus.NOT_FOUND)
                    .body(KafkaResponseView.to(false));

//        try {
        this.kafkaService.send(topic, body);
//        } catch(Exception e) {
//            return ResponseEntity
//                    .status(HttpStatus.INTERNAL_SERVER_ERROR)
//                    .body(false);
//        }

        return ResponseEntity.ok(KafkaResponseView.to(true));
    }

}
