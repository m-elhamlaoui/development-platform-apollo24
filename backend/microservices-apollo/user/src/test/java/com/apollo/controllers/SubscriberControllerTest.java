package com.apollo.controllers;

import static org.junit.jupiter.api.Assertions.*;

import com.apollo.entities.SubscriberEntity;
import com.apollo.repositories.SubscriberRepository;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;

import java.util.Collections;

import static org.mockito.ArgumentMatchers.any;
import static org.mockito.ArgumentMatchers.anyLong;
import static org.mockito.Mockito.when;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.content;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.jsonPath;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@WebMvcTest(SubscriberController.class)
class SubscriberControllerTest {

    @Autowired
    private MockMvc mockMvc;

    @MockBean
    private SubscriberRepository subscriberRepository;

    private SubscriberEntity subscriber;

    @BeforeEach
    public void setup() {
        subscriber = SubscriberEntity.builder()
                .idSubscriber(1L)
                .email("test@example.com")
                .region("Test Region")
                .build();
    }

    @Test
    public void testGetSubscribers() throws Exception {
        when(subscriberRepository.findAll()).thenReturn(Collections.singletonList(subscriber));

        mockMvc.perform(MockMvcRequestBuilders.get("/subscribers"))
                .andExpect(status().isOk())
                .andExpect(content().contentType(MediaType.APPLICATION_JSON))
                .andExpect(jsonPath("$[0].idSubscriber").value(subscriber.getIdSubscriber()))
                .andExpect(jsonPath("$[0].email").value(subscriber.getEmail()));
    }

    @Test
    public void testCreateSubscriber() throws Exception {
        when(subscriberRepository.save(any(SubscriberEntity.class))).thenReturn(subscriber);

        String subscriberJson = "{ \"email\": \"test@example.com\", \"region\": \"Test Region\" }";

        mockMvc.perform(MockMvcRequestBuilders.post("/subscribers")
                        .contentType(MediaType.APPLICATION_JSON)
                        .content(subscriberJson))
                .andExpect(status().isCreated())
                .andExpect(jsonPath("$.idSubscriber").value(subscriber.getIdSubscriber()))
                .andExpect(jsonPath("$.email").value(subscriber.getEmail()));
    }

    @Test
    public void testModifySubscriber() throws Exception {
        when(subscriberRepository.findById(anyLong())).thenReturn(java.util.Optional.of(subscriber));
        when(subscriberRepository.save(any(SubscriberEntity.class))).thenReturn(subscriber);

        String subscriberJson = "{ \"email\": \"updated@example.com\", \"region\": \"Updated Region\" }";

        mockMvc.perform(MockMvcRequestBuilders.put("/subscribers/{id}", subscriber.getIdSubscriber())
                        .contentType(MediaType.APPLICATION_JSON)
                        .content(subscriberJson))
                .andExpect(status().isOk())
                .andExpect(jsonPath("$.idSubscriber").value(subscriber.getIdSubscriber()))
                .andExpect(jsonPath("$.email").value("updated@example.com"));
    }

    @Test
    public void testDeleteSubscriber() throws Exception {
        mockMvc.perform(MockMvcRequestBuilders.delete("/subscribers/{id}", subscriber.getIdSubscriber()))
                .andExpect(status().isOk())
                .andExpect(content().string("subscriber deleted successfully"));
    }

}