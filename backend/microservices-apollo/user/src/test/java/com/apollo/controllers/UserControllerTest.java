package com.apollo.controllers;

import static org.junit.jupiter.api.Assertions.*;

import com.apollo.entities.UserEntity;
import com.apollo.service.KafkaProducerService;
import com.apollo.repositories.SubscriberRepository;
import com.apollo.repositories.UserRepository;
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
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.jsonPath;

@WebMvcTest(UserController.class)
class UserControllerTest {

    @Autowired
    private MockMvc mockMvc;

    @MockBean
    private UserRepository userRepo;

    @MockBean
    private SubscriberRepository subscriberRepo;

    @MockBean
    private KafkaProducerService kafkaProducerService;

    private UserEntity user;

    @BeforeEach
    public void setup() {
        user = UserEntity.builder()
                .idUser(1L)
                .username("testuser")
                .password("password")
                .fullname("Test User")
                .email("test@example.com")
                .data("Some data")
                .build();
    }

    @Test
    public void testGetUsers() throws Exception {
        when(userRepo.findAll()).thenReturn(Collections.singletonList(user));

        mockMvc.perform(MockMvcRequestBuilders.get("/users"))
                .andExpect(status().isOk())
                .andExpect(content().contentType(MediaType.APPLICATION_JSON))
                .andExpect(jsonPath("$[0].idUser").value(user.getIdUser()))
                .andExpect(jsonPath("$[0].username").value(user.getUsername()));
    }

    @Test
    public void testCreateUser() throws Exception {
        when(userRepo.save(any(UserEntity.class))).thenReturn(user);

        String userJson = "{ \"username\": \"testuser\", \"password\": \"password\", \"fullname\": \"Test User\", \"email\": \"test@example.com\", \"data\": \"Some data\" }";

        mockMvc.perform(MockMvcRequestBuilders.post("/users")
                        .contentType(MediaType.APPLICATION_JSON)
                        .content(userJson))
                .andExpect(status().isCreated())
                .andExpect(jsonPath("$.idUser").value(user.getIdUser()))
                .andExpect(jsonPath("$.username").value(user.getUsername()));
    }

    @Test
    public void testModifyUser() throws Exception {
        when(userRepo.findById(anyLong())).thenReturn(java.util.Optional.of(user));
        when(userRepo.save(any(UserEntity.class))).thenReturn(user);

        String userJson = "{ \"username\": \"updateduser\", \"password\": \"password\", \"fullname\": \"Updated User\", \"email\": \"updated@example.com\", \"data\": \"Updated data\" }";

        mockMvc.perform(MockMvcRequestBuilders.put("/users/{id}", user.getIdUser())
                        .contentType(MediaType.APPLICATION_JSON)
                        .content(userJson))
                .andExpect(status().isOk())
                .andExpect(jsonPath("$.idUser").value(user.getIdUser()))
                .andExpect(jsonPath("$.username").value("updateduser"));
    }

    @Test
    public void testDeleteUser() throws Exception {
        mockMvc.perform(MockMvcRequestBuilders.delete("/users/{id}", user.getIdUser()))
                .andExpect(status().isOk())
                .andExpect(content().string("user deleted successfully"));
    }

}