package com.bsmm.services.handler;

import org.springframework.web.reactive.function.server.ServerRequest;
import org.springframework.web.reactive.function.server.ServerResponse;
import reactor.core.publisher.Mono;

public interface MessageHandler {
    Mono<ServerResponse> getById(ServerRequest serverRequest);

    Mono<ServerResponse> getAll(ServerRequest serverRequest);

    Mono<ServerResponse> create(ServerRequest serverRequest);

    Mono<ServerResponse> deleteById(ServerRequest serverRequest);
}
