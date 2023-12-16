package com.idb.example.microserviceexample.repository;

import com.idb.example.microserviceexample.entity.ExampleEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.UUID;


@Repository
public interface IExampleRepository extends JpaRepository<ExampleEntity, Long> {
    void deleteByUuid(UUID uuid);
}
