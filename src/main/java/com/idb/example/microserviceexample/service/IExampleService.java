package com.idb.example.microserviceexample.service;

import com.idb.example.microserviceexample.model.ExampleDto;

import java.util.UUID;

public interface IExampleService {
    ExampleDto create(ExampleDto dto);
    ExampleDto update(ExampleDto dto);
    void deleteById(Long id);
    void deleteByUuid(UUID uuid);
}
