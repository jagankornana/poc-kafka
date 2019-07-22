package com.kafka.poc.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.stereotype.Service;

@Service
public class KafkaSender {

    @Autowired
    private KafkaTemplate<String, String> kafkaTemplate;

    @Value("${topic.name}")
    private String topicName;

    public void send(String message) {
        kafkaTemplate.send(topicName, message);
    }
}
