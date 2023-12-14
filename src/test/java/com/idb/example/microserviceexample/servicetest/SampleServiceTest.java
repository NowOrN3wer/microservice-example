package com.idb.example.microserviceSample.servicetest;

import com.idb.example.microserviceexample.entity.Sample;
import com.idb.example.microserviceexample.model.SampleDto;
import com.idb.example.microserviceexample.repository.ISampleRepository;
import com.idb.example.microserviceexample.service.imp.SampleServiceImp;
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
public class SampleServiceTest {
    private static SampleDto dto;
    private static Sample entity;
    @Mock
    private ISampleRepository repository;
    @InjectMocks
    private SampleServiceImp service;
    @Mock
    private ModelMapper modelMapper;

    @BeforeAll
    public static void intTests() {
        entity = new Sample();
        entity.setName("name");
        entity.setId(1L);
        entity.setVersion(1);
        dto = new SampleDto();
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
        Mockito.when(repository.save(any(Sample.class))).thenReturn(entity);
        when(modelMapper.map(eq(dto), eq(Sample.class))).thenReturn(entity);
        when(modelMapper.map(eq(entity), eq(SampleDto.class))).thenReturn(dto);
        SampleDto result = service.create(dto);
        assertNotNull(result);
        assertEquals(dto, result);
    }
    @Test
    public void updateTest() {
        Mockito.when(repository.save(any(Sample.class))).thenReturn(entity);
        when(modelMapper.map(eq(dto), eq(Sample.class))).thenReturn(entity);
        when(modelMapper.map(eq(entity), eq(SampleDto.class))).thenReturn(dto);
        SampleDto result = service.update(dto);
        assertNotNull(result);
        assertEquals(dto, result);
    }
}
