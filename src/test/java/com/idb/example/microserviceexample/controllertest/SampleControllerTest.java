package com.idb.example.microserviceexample.controllertest;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.idb.example.microserviceexample.controller.SampleController;
import com.idb.example.microserviceexample.model.SampleDto;
import com.idb.example.microserviceexample.service.ISampleService;
import org.junit.Before;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.http.MediaType;
import org.springframework.test.context.web.WebAppConfiguration;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;
import org.springframework.web.context.WebApplicationContext;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;
import static org.mockito.Mockito.when;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.put;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@WebMvcTest(SampleController.class)
@WebAppConfiguration
public class SampleControllerTest {
    private static SampleDto dto;
    @Autowired
    private WebApplicationContext context;
    @Autowired
    MockMvc mockMvc;

    @MockBean
    private ISampleService service;

    private final String apiString = "/api/sample/";

    @Before
    public void before() {
        mockMvc = MockMvcBuilders.webAppContextSetup(context).build();
    }

    @BeforeAll
    public static void intTests() {
        dto = new SampleDto();
        dto.setName("name");
        dto.setId(1L);
        dto.setVersion(1);
    }

    @Test
    public void createTest() throws Exception {
        when(service.create(dto)).thenReturn(dto);
        mockMvc.perform(post(apiString + "create")
                        .contentType(MediaType.APPLICATION_JSON)
                        .content(new ObjectMapper().writeValueAsString(dto)))
                .andExpect(status().isCreated());
        SampleDto result = service.create(dto);
        assertNotNull(result);
        assertEquals(dto, result);
    }

    @Test
    public void updateTest() throws Exception {
        when(service.update(dto)).thenReturn(dto);
        mockMvc.perform(put(apiString + "update")
                        .contentType(MediaType.APPLICATION_JSON)
                        .content(new ObjectMapper().writeValueAsString(dto)))
                .andExpect(status().isOk());
        SampleDto result = service.update(dto);
        assertNotNull(result);
        assertEquals(dto, result);
    }
}