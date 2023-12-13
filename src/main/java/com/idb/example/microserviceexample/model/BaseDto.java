package com.idb.example.microserviceexample.model;

import jakarta.persistence.*;
import lombok.Data;

import java.time.LocalDateTime;
import java.util.UUID;
@Data
@MappedSuperclass
public abstract class BaseDto {
    private Long id;
    private UUID uuid;
    private Integer version;
    private LocalDateTime createdAt;
    private LocalDateTime updatedAt;
}
