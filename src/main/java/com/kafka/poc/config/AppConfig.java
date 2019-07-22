package com.kafka.poc.config;

import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;

@Configuration
@ComponentScan(basePackages = {"com.kafka.poc.config",
        "com.kafka.poc.controller",
        "com.kafka.poc.service"
    })
public class AppConfig {

}
