package com.kafka.poc.controller;

import com.kafka.poc.domain.Message;
import com.kafka.poc.service.KafkaSender;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/kafka")
public class KafkaController {

    private static final Logger LOGGER = LoggerFactory.getLogger(KafkaController.class);

    @Autowired
    private KafkaSender kafkaSender;

    @PostMapping("send")
    public String sendMessage(@RequestBody Message message) {
        LOGGER.info("sendMessage :: request :: {}", message);
        kafkaSender.send(message.getBody());
        return "Message sent to topic successfully";
    }
}
