package com.idb.example.microserviceexample.service.imp;

import com.idb.example.microserviceexample.entity.Example;
import com.idb.example.microserviceexample.model.ExampleDto;
import com.idb.example.microserviceexample.repository.IExampleRepository;
import com.idb.example.microserviceexample.service.IExampleService;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.UUID;

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

    @Override
    public ExampleDto update(ExampleDto dto) {
        var entity = dtoToEntity(dto);
        return entityToDto(repository.save(entity));
    }

    @Override
    public void deleteById(Long id) {
        repository.deleteById(id);
    }

    @Override
    @Transactional
    public void deleteByUuid(UUID uuid) {
        repository.deleteByUuid(uuid);
    }

    private Example dtoToEntity(ExampleDto dto) {
        return modelMapper.map(dto, Example.class);
    }

    private ExampleDto entityToDto(Example entity) {
        return modelMapper.map(entity, ExampleDto.class);
    }
}
