package com.bsmm.services.model;

import lombok.Data;
import org.springframework.data.annotation.Id;
import org.springframework.data.annotation.Version;
import org.springframework.data.redis.core.RedisHash;

import java.io.Serializable;

@Data
@RedisHash("Message")
public class Message implements Serializable {
    @Id
    private String id;
    @Version
    private int version;
    private String status;
}
