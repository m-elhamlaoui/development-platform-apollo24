package com.apollo.controllers;

import static org.junit.jupiter.api.Assertions.*;

import static org.mockito.Mockito.*;

import java.util.Arrays;
import java.util.List;
import java.util.Optional;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;

import com.apollo.entities.SubscriberEntity;
import com.apollo.repositories.SubscriberRepository;

@SpringBootTest
class SubscriberControllerTest {

    @Mock
    private SubscriberRepository subscriberRepo;

    @InjectMocks
    private SubscriberController subscriberController;

    @BeforeEach
    void setUp() {
        MockitoAnnotations.openMocks(this);
    }

    @Test
    void testGetSubscribers() {
        SubscriberEntity subscriber1 = SubscriberEntity.builder().idSubscriber(1L).email("test1@example.com").region("region1").build();
        SubscriberEntity subscriber2 = SubscriberEntity.builder().idSubscriber(2L).email("test2@example.com").region("region2").build();
        List<SubscriberEntity> subscribers = Arrays.asList(subscriber1, subscriber2);

        when(subscriberRepo.findAll()).thenReturn(subscribers);

        List<SubscriberEntity> result = subscriberController.getSubscribers();

        assertNotNull(result);
        assertEquals(2, result.size());
        verify(subscriberRepo, times(1)).findAll();
    }

    @Test
    void testCreateSubscriber() {
        SubscriberEntity subscriber = SubscriberEntity.builder().idSubscriber(1L).email("test@example.com").region("region").build();
        when(subscriberRepo.save(any(SubscriberEntity.class))).thenReturn(subscriber);

        ResponseEntity<SubscriberEntity> response = subscriberController.createSubscriber(subscriber);

        assertNotNull(response);
        assertEquals(HttpStatus.CREATED, response.getStatusCode());
        assertNotNull(response.getBody());
        assertEquals(1L, response.getBody().getIdSubscriber());
        verify(subscriberRepo, times(1)).save(subscriber);
    }

    @Test
    void testModifySubscriber() {
        SubscriberEntity subscriber = SubscriberEntity.builder().idSubscriber(1L).email("test@example.com").region("region").build();
        when(subscriberRepo.findById(1L)).thenReturn(Optional.of(subscriber));

        SubscriberEntity updatedSubscriber = SubscriberEntity.builder().email("newEmail@example.com").region("newRegion").build();
        ResponseEntity<SubscriberEntity> response = subscriberController.modifySubscriber(1L, updatedSubscriber);

        assertNotNull(response);
        assertEquals(HttpStatus.OK, response.getStatusCode());
        assertNotNull(response.getBody());
        assertEquals(1L, response.getBody().getIdSubscriber());
        assertEquals("newEmail@example.com", response.getBody().getEmail());
        assertEquals("newRegion", response.getBody().getRegion());
        verify(subscriberRepo, times(1)).findById(1L);
        verify(subscriberRepo, times(1)).save(any(SubscriberEntity.class));
    }

    @Test
    void testModifySubscriber_NotFound() {
        when(subscriberRepo.findById(1L)).thenReturn(Optional.empty());

        SubscriberEntity updatedSubscriber = SubscriberEntity.builder().email("newEmail@example.com").region("newRegion").build();
        ResponseEntity<SubscriberEntity> response = subscriberController.modifySubscriber(1L, updatedSubscriber);

        assertNotNull(response);
        assertEquals(HttpStatus.NOT_FOUND, response.getStatusCode());
        assertNull(response.getBody());
        verify(subscriberRepo, times(1)).findById(1L);
        verify(subscriberRepo, times(0)).save(any(SubscriberEntity.class));
    }

    @Test
    void testModifyPartiallySubscriber() {
        SubscriberEntity subscriber = SubscriberEntity.builder().idSubscriber(1L).email("test@example.com").region("region").build();
        when(subscriberRepo.findById(1L)).thenReturn(Optional.of(subscriber));

        SubscriberEntity partialUpdate = SubscriberEntity.builder().email("newEmail@example.com").build();
        ResponseEntity<SubscriberEntity> response = subscriberController.modifyPartiallySubscriber(1L, partialUpdate);

        assertNotNull(response);
        assertEquals(HttpStatus.OK, response.getStatusCode());
        assertNotNull(response.getBody());
        assertEquals(1L, response.getBody().getIdSubscriber());
        assertEquals("newEmail@example.com", response.getBody().getEmail());
        assertEquals("region", response.getBody().getRegion());
        verify(subscriberRepo, times(1)).findById(1L);
        verify(subscriberRepo, times(1)).save(any(SubscriberEntity.class));
    }

    @Test
    void testModifyPartiallySubscriber_NotFound() {
        when(subscriberRepo.findById(1L)).thenReturn(Optional.empty());

        SubscriberEntity partialUpdate = SubscriberEntity.builder().email("newEmail@example.com").build();
        ResponseEntity<SubscriberEntity> response = subscriberController.modifyPartiallySubscriber(1L, partialUpdate);

        assertNotNull(response);
        assertEquals(HttpStatus.NOT_FOUND, response.getStatusCode());
        assertNull(response.getBody());
        verify(subscriberRepo, times(1)).findById(1L);
        verify(subscriberRepo, times(0)).save(any(SubscriberEntity.class));
    }

    @Test
    void testUnsubscribe() {
        ResponseEntity<String> response = subscriberController.unsubscribe(1L);

        assertNotNull(response);
        assertEquals(HttpStatus.OK, response.getStatusCode());
        assertEquals("subscriber deleted succesfully", response.getBody());
        verify(subscriberRepo, times(1)).deleteById(1L);
    }

}