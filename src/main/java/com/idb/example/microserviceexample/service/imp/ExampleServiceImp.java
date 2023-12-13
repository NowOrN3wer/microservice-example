package com.idb.example.microserviceexample.service.imp;

import com.idb.example.microserviceexample.entity.Example;
import com.idb.example.microserviceexample.model.ExampleDto;
import com.idb.example.microserviceexample.repository.IExampleRepository;
import com.idb.example.microserviceexample.service.IExampleService;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class ExampleServiceImp implements IExampleService {

    @Autowired
    private final IExampleRepository repository;
    ModelMapper modelMapper = new ModelMapper();

    public ExampleServiceImp(IExampleRepository repository) {
        this.repository = repository;
    }

    @Override
    public ExampleDto create(ExampleDto dto) {
        var entity = dtoToEntity(dto);
        return entityToDto(repository.save(entity));
    }

    private Example dtoToEntity(ExampleDto dto){
        return modelMapper.map(dto, Example.class);
    }

    private ExampleDto entityToDto(Example entity){
       return modelMapper.map(entity, ExampleDto.class);
    }
}
