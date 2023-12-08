package com.example.msawebfluxrediskafkaproducer.service.impl;

import com.example.msawebfluxrediskafkaproducer.service.StorageeService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.codec.multipart.Part;
import org.springframework.stereotype.Service;
import org.springframework.util.MultiValueMap;
import reactor.core.publisher.Mono;

@Service
@RequiredArgsConstructor
@Slf4j
public class StorageeServiceImpl implements StorageeService {

    @Override
    public Mono<Void> saveFile(Mono<MultiValueMap<String, Part>> map) {
        return map.doOnNext(stringPartMultiValueMap -> log.info("{}", stringPartMultiValueMap.get("file")))
                .then();
    }
}
