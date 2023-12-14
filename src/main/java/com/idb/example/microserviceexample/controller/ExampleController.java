package com.idb.example.microserviceexample.controller;

import com.idb.example.microserviceexample.model.ExampleDto;
import com.idb.example.microserviceexample.service.IExampleService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.UUID;

@RestController
@RequestMapping("api/example/")
public class ExampleController {
    private final IExampleService service;

    public ExampleController(IExampleService service) {
        this.service = service;
    }

    @PostMapping("create")
    public ResponseEntity<?> create(@RequestBody ExampleDto dto) {
        return new ResponseEntity<>(service.create(dto), HttpStatus.CREATED);
    }

    @PutMapping("update")
    public ResponseEntity<?> update(@RequestBody ExampleDto dto) {
        return new ResponseEntity<>(service.update(dto), HttpStatus.OK);
    }

    @DeleteMapping("deleteById/{id}")
    public ResponseEntity<?> deleteById(@PathVariable Long id) {
        service.deleteById(id);
        return new ResponseEntity<>(HttpStatus.OK);
    }
    @DeleteMapping("deleteByUuid/{uuid}")
    public ResponseEntity<?> deleteByUuid(@PathVariable UUID uuid) {
        service.deleteByUuid(uuid);
        return new ResponseEntity<>(HttpStatus.OK);
    }
}