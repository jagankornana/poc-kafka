package com.kafka.poc.service;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.stereotype.Service;

@Service
public class KafkaSender {

    private static final Logger LOGGER = LoggerFactory.getLogger(KafkaSender.class);

    @Autowired
    private KafkaTemplate<String, String> kafkaTemplate;

    @Value("${topic.name}")
    private String topicName;

    public void send(String message) {
        LOGGER.info("Sending message={} to topic={}", message, topicName);
        kafkaTemplate.send(topicName, message);
    }
}
