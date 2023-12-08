package com.example.msawebfluxrediskafkaproducer.handler;

import org.springframework.web.reactive.function.server.ServerRequest;
import org.springframework.web.reactive.function.server.ServerResponse;
import reactor.core.publisher.Mono;

public interface StorageHandler {
    Mono<ServerResponse> saveFile(ServerRequest serverRequest);

}
