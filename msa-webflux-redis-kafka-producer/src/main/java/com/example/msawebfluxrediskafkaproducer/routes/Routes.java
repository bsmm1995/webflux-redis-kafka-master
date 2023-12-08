package com.example.msawebfluxrediskafkaproducer.routes;


import com.example.msawebfluxrediskafkaproducer.handler.StorageHandler;
import org.springframework.context.annotation.Bean;
import org.springframework.http.MediaType;
import org.springframework.stereotype.Component;
import org.springframework.web.reactive.function.server.RequestPredicates;
import org.springframework.web.reactive.function.server.RouterFunction;
import org.springframework.web.reactive.function.server.ServerResponse;

import static org.springframework.web.reactive.function.server.RouterFunctions.route;

@Component
public class Routes {
    @Bean
    public RouterFunction<ServerResponse> accountsRoutes(StorageHandler handler) {
        return route().path("/file/upload", builder -> builder
                        .POST("", RequestPredicates.contentType(MediaType.MULTIPART_FORM_DATA), handler::saveFile))
                .build();
    }
}