package com.idb.example.microserviceexample.model;

import jakarta.persistence.MappedSuperclass;
import lombok.Data;

import java.time.LocalDateTime;
import java.util.UUID;

@Data
@MappedSuperclass
public abstract class BaseSoftDeleteDto {
    private Long id;
    private UUID uuid;
    private Integer version;
    private LocalDateTime createdAt;
    private LocalDateTime updatedAt;
    private Boolean deleted;
}
