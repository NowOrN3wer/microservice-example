package com.idb.example.microserviceexample.controller;

import com.idb.example.microserviceexample.model.ExampleDto;
import com.idb.example.microserviceexample.model.SampleDto;
import com.idb.example.microserviceexample.service.IExampleService;
import com.idb.example.microserviceexample.service.ISampleService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("api/sample/")
public class SampleController {
    private final ISampleService service;

    public SampleController(ISampleService service) {
        this.service = service;
    }

    @PostMapping("create")
    public ResponseEntity<?> create(@RequestBody SampleDto dto) {
        return new ResponseEntity<>(service.create(dto), HttpStatus.CREATED);
    }
    @PutMapping("update")
    public ResponseEntity<?> update(@RequestBody SampleDto dto) {
        return new ResponseEntity<>(service.update(dto), HttpStatus.OK);
    }
}