package com.example.msawebfluxrediskafkaproducer.service;

import org.springframework.http.codec.multipart.Part;
import org.springframework.util.MultiValueMap;
import reactor.core.publisher.Mono;

public interface StorageeService {
    Mono<Void> saveFile(Mono<MultiValueMap<String, Part>> map);
}
