package com.idb.example.microserviceexample.service;

import com.idb.example.microserviceexample.model.SampleDto;

public interface ISampleService {
    SampleDto create(SampleDto dto);

    SampleDto update(SampleDto dto);

}
