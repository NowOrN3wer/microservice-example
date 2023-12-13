package com.idb.example.microserviceexample.controller;

import com.idb.example.microserviceexample.model.ExampleDto;
import com.idb.example.microserviceexample.service.IExampleService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("api/example/")
public class ExampleController {
    private final IExampleService service;

    public ExampleController(IExampleService service) {
        this.service = service;
    }

    @GetMapping("getMessage")
    ResponseEntity<?> getAllProducts() {
        return new ResponseEntity<>("HELLO WORD", HttpStatus.OK);
    }

    @PostMapping("save")
    public ResponseEntity<?> create(@RequestBody ExampleDto dto) {
        return new ResponseEntity<>(service.create(dto), HttpStatus.CREATED);
    }

}