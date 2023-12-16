package com.idb.example.microserviceexample.service;

import com.idb.example.microserviceexample.model.ExampleDto;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import java.util.List;
import java.util.UUID;

public interface IExampleService {
    ExampleDto create(ExampleDto dto);

    ExampleDto update(ExampleDto dto);

    void deleteById(Long id);

    void deleteByUuid(UUID uuid);

    List<ExampleDto> getList();

    Page<ExampleDto> getPage(ExampleDto queryDto, Pageable pageable);
}
