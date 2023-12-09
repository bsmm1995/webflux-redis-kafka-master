package com.example.msawebfluxrediskafkaproducer.service.impl;

import com.example.msawebfluxrediskafkaproducer.service.StorageService;
import com.example.msawebfluxrediskafkaproducer.service.dto.StorageMessage;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.codec.multipart.Part;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.stereotype.Service;
import org.springframework.util.MultiValueMap;
import reactor.core.publisher.Mono;

import java.io.Serializable;
import java.util.UUID;

@Service
@RequiredArgsConstructor
@Slf4j
public class StorageServiceImpl implements StorageService {
    private final KafkaTemplate<String, Serializable> kafkaTemplate;

    @Override
    public Mono<Void> saveFile(Mono<MultiValueMap<String, Part>> mapMono) {
        return mapMono.mapNotNull(multiValueMap -> {
            log.info("{}", multiValueMap.get("file"));
            return multiValueMap.getFirst("file");
        }).map(part -> {
            var message = new StorageMessage(UUID.randomUUID().toString(), "IN_ANALYSIS", part.toString());
            log.info("Sending message to KAFKA {}", message);
            kafkaTemplate.send("storage-topic", message);
            return Mono.empty();
        }).then();
    }
}
