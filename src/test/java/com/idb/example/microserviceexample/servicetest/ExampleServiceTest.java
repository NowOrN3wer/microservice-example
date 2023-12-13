package com.idb.example.microserviceexample.servicetest;

import com.idb.example.microserviceexample.entity.Example;
import com.idb.example.microserviceexample.model.ExampleDto;
import com.idb.example.microserviceexample.repository.IExampleRepository;
import com.idb.example.microserviceexample.service.imp.ExampleServiceImp;
import org.junit.Before;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.MockitoAnnotations;
import org.modelmapper.ModelMapper;
import org.springframework.test.context.junit.jupiter.SpringExtension;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;
import static org.mockito.Mockito.*;

@ExtendWith(SpringExtension.class)
public class ExampleServiceTest {
    private static ExampleDto dto;
    private static Example entity;
    @Mock
    private IExampleRepository repository;
    @InjectMocks
    private ExampleServiceImp service;
    @Mock
    private ModelMapper modelMapper;

    @BeforeAll
    public static void intTests() {
        entity = new Example();
        entity.setName("name");
        entity.setId(1L);
        entity.setVersion(1);
        dto = new ExampleDto();
        dto.setName("name");
        dto.setId(1L);
        dto.setVersion(1);
    }

    @Before
    public void setUp() {
        MockitoAnnotations.initMocks(this);
        MockitoAnnotations.openMocks(this);
    }

    @Test
    public void createTest() {
        Mockito.when(repository.save(any(Example.class))).thenReturn(entity);
        when(modelMapper.map(eq(dto), eq(Example.class))).thenReturn(entity);
        when(modelMapper.map(eq(entity), eq(ExampleDto.class))).thenReturn(dto);
        ExampleDto result = service.create(dto);
        assertNotNull(result);
        assertEquals(dto, result);
    }
    @Test
    public void updateTest() {
        Mockito.when(repository.save(any(Example.class))).thenReturn(entity);
        when(modelMapper.map(eq(dto), eq(Example.class))).thenReturn(entity);
        when(modelMapper.map(eq(entity), eq(ExampleDto.class))).thenReturn(dto);
        ExampleDto result = service.update(dto);
        assertNotNull(result);
        assertEquals(dto, result);
    }
}
