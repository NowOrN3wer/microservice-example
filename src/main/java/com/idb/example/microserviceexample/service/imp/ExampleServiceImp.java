package com.idb.example.microserviceexample.service.imp;

import com.idb.example.microserviceexample.entity.Example;
import com.idb.example.microserviceexample.model.ExampleDto;
import com.idb.example.microserviceexample.repository.IExampleRepository;
import com.idb.example.microserviceexample.service.IExampleService;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Service;

@Service
public class ExampleServiceImp implements IExampleService {
    private final IExampleRepository repository;
    ModelMapper modelMapper = new ModelMapper();

    public ExampleServiceImp(IExampleRepository repository) {
        this.repository = repository;
    }

    @Override
    public ExampleDto save(ExampleDto dto) {
        var entity = modelMapper.map(dto, Example.class);
        return modelMapper.map(repository.save(entity), ExampleDto.class);
    }
}
