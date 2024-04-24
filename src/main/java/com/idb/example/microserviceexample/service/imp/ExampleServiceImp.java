package com.idb.example.microserviceexample.service.imp;

import com.idb.example.microserviceexample.entity.ExampleEntity;
import com.idb.example.microserviceexample.model.ExampleDto;
import com.idb.example.microserviceexample.repository.IExampleRepository;
import com.idb.example.microserviceexample.service.IExampleService;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.*;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.UUID;
import java.util.stream.Collectors;

import static org.springframework.data.domain.ExampleMatcher.GenericPropertyMatchers.contains;
import static org.springframework.data.domain.ExampleMatcher.GenericPropertyMatchers.exact;

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

    @Override
    public List<ExampleDto> getList() {
        return repository.findAll().stream().map((entity) ->
                modelMapper.map(entity, ExampleDto.class)).collect(Collectors.toList());
    }

    @Override
    public Page<ExampleDto> getPage(ExampleDto queryDto, Pageable pageable) {
        ExampleMatcher matcher = ExampleMatcher.matchingAny()
                .withMatcher("name", contains().ignoreCase()).
                withMatcher("id", exact());
        Example<ExampleEntity> filter = Example.of(dtoToEntity(queryDto), matcher);
        return toPageObjectDto(repository.findAll(filter, pageable));
    }

    private Page<ExampleDto> toPageObjectDto(Page<ExampleEntity> objects) {
        return objects.map(this::entityToDto);
    }

    private ExampleEntity dtoToEntity(ExampleDto dto) {
        return modelMapper.map(dto, ExampleEntity.class);
    }

    private ExampleDto entityToDto(ExampleEntity entity) {
        return modelMapper.map(entity, ExampleDto.class);
    }
}
