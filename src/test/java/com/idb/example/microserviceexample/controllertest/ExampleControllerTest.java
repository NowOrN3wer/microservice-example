package com.idb.example.microserviceexample.controllertest;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.idb.example.microserviceexample.controller.ExampleController;
import com.idb.example.microserviceexample.model.ExampleDto;
import com.idb.example.microserviceexample.service.IExampleService;
import org.junit.Before;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.http.MediaType;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit.jupiter.SpringExtension;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.test.context.web.WebAppConfiguration;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;
import org.springframework.web.context.WebApplicationContext;

import static org.mockito.Mockito.when;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.*;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.*;

@WebMvcTest(ExampleController.class)
@WebAppConfiguration
public class ExampleControllerTest {
    private static ExampleDto dto;
    @Autowired
    private WebApplicationContext context;
    @Autowired
    MockMvc mockMvc;

    @MockBean
    private IExampleService service;

    @Before
    public void before() {
        mockMvc = MockMvcBuilders.webAppContextSetup(context).build();
    }
    @BeforeAll
    public static void intTests() {
        dto = new ExampleDto();
        dto.setName("name");
        dto.setId(1L);
        dto.setVersion(1);

    }

    @Test
    public void createTest() throws Exception {
        when(service.create(dto)).thenReturn(dto);
        mockMvc.perform(post("/api/example/create")
                        .contentType(MediaType.APPLICATION_JSON)
                        .content(new ObjectMapper().writeValueAsString(dto)))
                .andExpect(status().isCreated());
    }

}