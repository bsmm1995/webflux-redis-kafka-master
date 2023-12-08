package com.bsmm.services.service;

import com.bsmm.services.service.dto.MessageDTO;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

public interface MessageService {
    Mono<MessageDTO> getById(String id);

    Flux<MessageDTO> getAll();

    Mono<MessageDTO> create(Mono<MessageDTO> dto);

    Mono<Long> deleteById(String id);
}
