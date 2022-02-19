package com.example.springkafkademo.controller;

import com.example.springkafkademo.model.AddressDetails;
import com.example.springkafkademo.model.UserDetails;
import com.example.springkafkademo.service.KafkaConsumerService;
import com.example.springkafkademo.service.KafkaProducerService;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.request.MockHttpServletRequestBuilder;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;

import static org.hamcrest.Matchers.is;
import static org.hamcrest.Matchers.notNullValue;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.jsonPath;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@WebMvcTest(CtmInsuranceController.class)
public class CtmInsuranceControllerTest {

    @Autowired
    MockMvc mockMvc;

    @Autowired
    ObjectMapper mapper;

    @MockBean
    KafkaProducerService kafkaProducerService;

    @MockBean
    KafkaConsumerService kafkaConsumerService;


    @Test
    public void createUserDetails() throws Exception {
        UserDetails record = UserDetails.builder()
                .userId("1111")
                .firstName("John")
                .lastName("Doe")
                .addressId("1234")
                .email("test@test.com")
                .dob("1990-01-01")
                .build();


        MockHttpServletRequestBuilder mockRequest = MockMvcRequestBuilders.post("/api/v1/userdetails")
                .contentType(MediaType.APPLICATION_JSON)
                .accept(MediaType.APPLICATION_JSON)
                .content(this.mapper.writeValueAsString(record));

        mockMvc.perform(mockRequest)
                .andExpect(status().isOk())
                .andExpect(jsonPath("$", notNullValue()))
                .andExpect(jsonPath("$.firstname", is("John")));
    }

    @Test
    public void createAddressDetails() throws Exception {
        AddressDetails record = AddressDetails.builder()
                .addressId("12345")
                .addressLine1("Titanic")
                .city("Belfast")
                .hNo("25")
                .pin("2345")
                .build();


        MockHttpServletRequestBuilder mockRequest = MockMvcRequestBuilders.post("/api/v1/addressdetails")
                .contentType(MediaType.APPLICATION_JSON)
                .accept(MediaType.APPLICATION_JSON)
                .content(this.mapper.writeValueAsString(record));

        mockMvc.perform(mockRequest)
                .andExpect(status().isOk())
                .andExpect(jsonPath("$", notNullValue()))
                .andExpect(jsonPath("$.city", is("Belfast")));
    }
}
