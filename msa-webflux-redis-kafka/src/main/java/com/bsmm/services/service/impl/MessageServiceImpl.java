package com.bsmm.services.service.impl;

import com.bsmm.services.model.Message;
import com.bsmm.services.service.MessageService;
import com.bsmm.services.service.dto.MessageDTO;
import com.bsmm.services.service.mapper.MessageMapper;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.data.redis.core.ReactiveRedisOperations;
import org.springframework.stereotype.Service;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

@Service
@RequiredArgsConstructor
@Slf4j
public class MessageServiceImpl implements MessageService {
    private final ReactiveRedisOperations<String, Message> redisOperations;

    @Override
    public Mono<MessageDTO> getById(String id) {
        return redisOperations.opsForValue().get(id).map(MessageMapper.INSTANCE::toDto);
    }

    @Override
    public Flux<MessageDTO> getAll() {
        return redisOperations.keys("*").flatMap(redisOperations.opsForValue()::get).map(MessageMapper.INSTANCE::toDto);
    }

    @Override
    public Mono<MessageDTO> create(Mono<MessageDTO> dto) {
        return dto.map(MessageMapper.INSTANCE::toEntity).flatMap(message -> redisOperations.opsForValue().set(message.getId(), message).map(e -> message)).doOnNext(e -> log.info("{}", e)).map(MessageMapper.INSTANCE::toDto);
    }

    @Override
    public Mono<Long> deleteById(String id) {
        return redisOperations.delete(id);
    }
}
