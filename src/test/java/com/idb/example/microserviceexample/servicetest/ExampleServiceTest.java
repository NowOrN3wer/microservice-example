package com.idb.example.microserviceexample.servicetest;

import com.idb.example.microserviceexample.entity.Example;
import com.idb.example.microserviceexample.model.ExampleDto;
import com.idb.example.microserviceexample.repository.IExampleRepository;
import com.idb.example.microserviceexample.service.IExampleService;
import com.idb.example.microserviceexample.service.imp.ExampleServiceImp;
import org.junit.Before;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.extension.ExtendWith;
import org.junit.runner.RunWith;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;
import static org.mockito.Mockito.*;
import static org.mockito.MockitoAnnotations.initMocks;

import org.junit.jupiter.api.Test;
import org.mockito.*;
import org.mockito.junit.MockitoJUnitRunner;
import org.mockito.junit.jupiter.MockitoExtension;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.jdbc.AutoConfigureTestDatabase;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.test.context.junit.jupiter.SpringExtension;

import java.time.LocalDateTime;
import java.util.Collection;
import java.util.Collections;

@ExtendWith(SpringExtension.class)
public class ExampleServiceTest {
    @Mock
    private IExampleRepository repository;
    @InjectMocks
    private ExampleServiceImp service;
    @Mock
    private ModelMapper modelMapper;
    private static ExampleDto dto;
    private static Example entity;

   @Before
    public void setUp(){
        MockitoAnnotations.initMocks(this);
        MockitoAnnotations.openMocks(this);
    }
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

    @Test
    public void createTest() {
        Mockito.when(repository.save(any(Example.class))).thenReturn(entity);
        when(modelMapper.map(eq(dto), eq(Example.class))).thenReturn(entity);
        when(modelMapper.map(eq(entity), eq(ExampleDto.class))).thenReturn(dto);
        ExampleDto result = service.create(dto);
        assertNotNull(result);
        assertEquals(dto, result);
    }
}
