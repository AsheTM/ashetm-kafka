package com.ashetm.project.kafka.models;

import lombok.*;

import java.util.Date;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class Message {

    String id;
    String content;
    Date now = new Date();

}
