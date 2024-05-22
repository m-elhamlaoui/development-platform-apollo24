package com.apollo.controllers;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.when;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.any;
import static org.mockito.Mockito.times;

import java.util.Arrays;
import java.util.Optional;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.boot.test.context.SpringBootTest;

import com.apollo.entities.SubscriberEntity;
import com.apollo.entities.UserEntity;
import com.apollo.repositories.SubscriberRepository;
import com.apollo.repositories.UserRepository;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.junit.jupiter.api.Assertions.assertNull;

@SpringBootTest
class UserControllerTest {

    @Mock
    private UserRepository userRepo;

    @Mock
    private SubscriberRepository subscriberRepo;

    @InjectMocks
    private UserController userController;

    @BeforeEach
    public void setUp() {
        MockitoAnnotations.openMocks(this);
    }

    @Test
    public void testGetUsers() {
        UserEntity user1 = new UserEntity(1L, "password1", "username1", "fullname1", "email1", "data1");
        UserEntity user2 = new UserEntity(2L, "password2", "username2", "fullname2", "email2", "data2");
        when(userRepo.findAll()).thenReturn(Arrays.asList(user1, user2));

        var users = userController.getUsers();

        assertNotNull(users);
        assertEquals(2, users.size());
        verify(userRepo, times(1)).findAll();
    }

    @Test
    public void testCreateUser() {
        UserEntity user = new UserEntity(null, "password", "username", "fullname", "email", "data");
        UserEntity savedUser = new UserEntity(1L, "password", "username", "fullname", "email", "data");
        when(userRepo.save(any(UserEntity.class))).thenReturn(savedUser);

        ResponseEntity<UserEntity> response = userController.createUser(user);

        assertNotNull(response);
        assertEquals(HttpStatus.CREATED, response.getStatusCode());
        assertNotNull(response.getBody());
        assertEquals(1L, response.getBody().getIdUser());
        verify(userRepo, times(1)).save(user);
    }

    @Test
    public void testModifyUser() {
        UserEntity user = new UserEntity(1L, "password", "username", "fullname", "email", "data");
        when(userRepo.findById(1L)).thenReturn(Optional.of(user));

        UserEntity updatedUser = new UserEntity(null, "newPassword", "newUsername", "newFullname", "newEmail", "newData");
        ResponseEntity<UserEntity> response = userController.modifyUser(1L, updatedUser);

        assertNotNull(response);
        assertEquals(HttpStatus.OK, response.getStatusCode());
        assertNotNull(response.getBody());
        assertEquals("newUsername", response.getBody().getUsername());
        verify(userRepo, times(1)).findById(1L);
        verify(userRepo, times(1)).save(any(UserEntity.class));
    }

    @Test
    public void testModifyUser_NotFound() {
        when(userRepo.findById(1L)).thenReturn(Optional.empty());

        UserEntity updatedUser = new UserEntity(null, "newPassword", "newUsername", "newFullname", "newEmail", "newData");
        ResponseEntity<UserEntity> response = userController.modifyUser(1L, updatedUser);

        assertNotNull(response);
        assertEquals(HttpStatus.NOT_FOUND, response.getStatusCode());
        assertNull(response.getBody());
        verify(userRepo, times(1)).findById(1L);
        verify(userRepo, times(0)).save(any(UserEntity.class));
    }

    @Test
    public void testModifyPartiallyUser() {
        UserEntity user = new UserEntity(1L, "password", "username", "fullname", "email", "data");
        when(userRepo.findById(1L)).thenReturn(Optional.of(user));

        UserEntity partialUpdate = new UserEntity(null, null, "newUsername", null, null, null);
        ResponseEntity<UserEntity> response = userController.modifyPartiallyUser(1L, partialUpdate);

        assertNotNull(response);
        assertEquals(HttpStatus.OK, response.getStatusCode());
        assertNotNull(response.getBody());
        assertEquals("newUsername", response.getBody().getUsername());
        verify(userRepo, times(1)).findById(1L);
        verify(userRepo, times(1)).save(any(UserEntity.class));
    }

    @Test
    public void testModifyPartiallyUser_NotFound() {
        when(userRepo.findById(1L)).thenReturn(Optional.empty());

        UserEntity partialUpdate = new UserEntity(null, null, "newUsername", null, null, null);
        ResponseEntity<UserEntity> response = userController.modifyPartiallyUser(1L, partialUpdate);

        assertNotNull(response);
        assertEquals(HttpStatus.NOT_FOUND, response.getStatusCode());
        assertNull(response.getBody());
        verify(userRepo, times(1)).findById(1L);
        verify(userRepo, times(0)).save(any(UserEntity.class));
    }

    @Test
    public void testSubscribe() {
        UserEntity user = new UserEntity(1L, "password", "username", "fullname", "email", "data");
        when(userRepo.findById(1L)).thenReturn(Optional.of(user));
        when(subscriberRepo.save(any(SubscriberEntity.class))).thenReturn(null);

        ResponseEntity<String> response = userController.subscribe("region1", user);

        assertNotNull(response);
        assertEquals(HttpStatus.CREATED, response.getStatusCode());
        assertEquals("user subscribed successfully", response.getBody());
        verify(userRepo, times(1)).findById(1L);
        verify(subscriberRepo, times(1)).save(any(SubscriberEntity.class));
    }

    @Test
    public void testDeleteUser() {
        ResponseEntity<String> response = userController.deleteUser(1L);

        assertNotNull(response);
        assertEquals(HttpStatus.OK, response.getStatusCode());
        assertEquals("user deleted successfully", response.getBody());
        verify(userRepo, times(1)).deleteById(1L);
    }
}
