package com.ashetm.project.kafka.dto;

import lombok.*;

@Getter
@Setter
@NoArgsConstructor(access = AccessLevel.PRIVATE)
@AllArgsConstructor(access = AccessLevel.PRIVATE)
public class KafkaResponseView {

    Boolean done;

    public static KafkaResponseView to(Boolean done) {
        return new KafkaResponseView(done);
    }

}
