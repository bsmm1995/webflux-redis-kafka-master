package com.bsmm.services.service;

import com.bsmm.services.service.dto.StorageMessage;
import lombok.extern.log4j.Log4j2;
import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.messaging.handler.annotation.Payload;
import org.springframework.stereotype.Service;

@Service
@Log4j2
public class StorageMessageService {
    @KafkaListener(topics = "storage-topic", groupId = "storage-group", containerFactory = "jsonContainerFactory")
    public void consumeMessage(@Payload StorageMessage message) {
        log.info("Reading storage message: {}", message);
    }
}
