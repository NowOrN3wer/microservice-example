package com.idb.example.microserviceexample.service.imp;

import com.idb.example.microserviceexample.entity.Sample;
import com.idb.example.microserviceexample.model.SampleDto;
import com.idb.example.microserviceexample.repository.ISampleRepository;
import com.idb.example.microserviceexample.service.ISampleService;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class SampleServiceImp implements ISampleService {

    @Autowired
    private final ISampleRepository repository;
    ModelMapper modelMapper = new ModelMapper();

    public SampleServiceImp(ISampleRepository repository) {
        this.repository = repository;
    }

    @Override
    public SampleDto create(SampleDto dto) {
        Sample entity = dtoToEntity(dto);
        return entityToDto(repository.save(entity));
    }
    @Override
    public SampleDto update(SampleDto dto) {
        var entity = dtoToEntity(dto);
        return entityToDto(repository.save(entity));
    }
    private Sample dtoToEntity(SampleDto dto) {
        return modelMapper.map(dto, Sample.class);
    }
    private SampleDto entityToDto(Sample entity) {
        return modelMapper.map(entity, SampleDto.class);
    }
}
