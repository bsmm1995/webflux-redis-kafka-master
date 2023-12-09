package com.example.msawebfluxrediskafkaproducer.service.dto;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.ToString;

import java.io.Serializable;

@Getter
@AllArgsConstructor
@ToString
public class StorageMessage implements Serializable {
    private String id;
    private String status;
    private String description;
}
