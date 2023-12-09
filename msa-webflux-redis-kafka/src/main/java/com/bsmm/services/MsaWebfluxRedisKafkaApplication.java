package com.bsmm.services;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.kafka.annotation.EnableKafka;

@EnableKafka
@SpringBootApplication
public class MsaWebfluxRedisKafkaApplication {

    public static void main(String[] args) {
        SpringApplication.run(MsaWebfluxRedisKafkaApplication.class, args);
    }

}
