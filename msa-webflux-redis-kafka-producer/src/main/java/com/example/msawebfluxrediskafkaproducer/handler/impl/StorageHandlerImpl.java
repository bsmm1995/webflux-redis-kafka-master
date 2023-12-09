package com.example.msawebfluxrediskafkaproducer.handler.impl;

import com.example.msawebfluxrediskafkaproducer.handler.StorageHandler;
import com.example.msawebfluxrediskafkaproducer.service.StorageService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Component;
import org.springframework.web.reactive.function.BodyExtractors;
import org.springframework.web.reactive.function.server.ServerRequest;
import org.springframework.web.reactive.function.server.ServerResponse;
import reactor.core.publisher.Mono;

@Slf4j
@Component
@RequiredArgsConstructor
public class StorageHandlerImpl implements StorageHandler {
    private final StorageService storageService;


    @Override
    public Mono<ServerResponse> saveFile(ServerRequest serverRequest) {
        return serverRequest.body(BodyExtractors.toMultipartData())
                .filter(map -> !map.isEmpty())
                .flatMap(stringPartMultiValueMap -> storageService.saveFile(Mono.just(stringPartMultiValueMap)))
                .then(Mono.defer(() -> ServerResponse.noContent().build()));
    }
}
