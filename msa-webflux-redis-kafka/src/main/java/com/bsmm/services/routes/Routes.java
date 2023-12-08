package com.bsmm.services.routes;


import com.bsmm.services.handler.MessageHandler;
import org.springframework.context.annotation.Bean;
import org.springframework.stereotype.Component;
import org.springframework.web.reactive.function.server.RouterFunction;
import org.springframework.web.reactive.function.server.ServerResponse;

import static org.springframework.web.reactive.function.server.RouterFunctions.route;

@Component
public class Routes {
    @Bean
    public RouterFunction<ServerResponse> accountsRoutes(MessageHandler handler) {
        return route().path("/messages", builder -> builder
                .GET("", handler::getAll)
                .GET("/{id}", handler::getById)
                .POST("", handler::create)
                .DELETE("/{id}", handler::deleteById)
        ).build();
    }
}