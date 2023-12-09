package com.bsmm.services.service.dto;

import lombok.Data;
import lombok.ToString;

import java.io.Serializable;

@Data
@ToString
public class StorageMessage implements Serializable {
    private String id;
    private String status;
    private String description;
}
