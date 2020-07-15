package com.ashetm.project.kafka.enums;

public enum KafkaTopic {

    TOPIC_1("TOPIC_1"), TOPIC_2("TOPIC_2");

    private String topic;

    private KafkaTopic(String topic) {
        this.topic = topic;
    }

    public String getTopic() {
        return this.topic;
    }

    public static boolean exists(String topic) {
        return TOPIC_1.getTopic().equals(topic)
                || TOPIC_2.getTopic().equals(topic);
    }

}
