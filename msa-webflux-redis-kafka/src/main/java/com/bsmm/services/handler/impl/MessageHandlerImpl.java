package com.bsmm.services.handler.impl;

import com.bsmm.services.handler.MessageHandler;
import com.bsmm.services.service.MessageService;
import com.bsmm.services.service.dto.MessageDTO;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Component;
import org.springframework.web.reactive.function.server.ServerRequest;
import org.springframework.web.reactive.function.server.ServerResponse;
import reactor.core.publisher.Mono;

@Slf4j
@Component
@RequiredArgsConstructor
public class MessageHandlerImpl implements MessageHandler {
    private final MessageService messageService;

    @Override
    public Mono<ServerResponse> getById(ServerRequest serverRequest) {
        String id = serverRequest.pathVariable("id");
        return ServerResponse.ok().body(messageService.getById(id), MessageDTO.class);
    }

    @Override
    public Mono<ServerResponse> getAll(ServerRequest serverRequest) {
        return ServerResponse.ok().body(messageService.getAll(), MessageDTO.class);
    }

    @Override
    public Mono<ServerResponse> create(ServerRequest serverRequest) {
        Mono<MessageDTO> dtoMono = serverRequest.bodyToMono(MessageDTO.class);
        return ServerResponse.status(HttpStatus.CREATED).body(messageService.create(dtoMono), MessageDTO.class);
    }

    @Override
    public Mono<ServerResponse> deleteById(ServerRequest serverRequest) {
        String id = serverRequest.pathVariable("id");
        return messageService.deleteById(id).then(Mono.defer(() -> ServerResponse.noContent().build()));
    }
}
