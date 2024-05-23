package com.apollo.service;

import com.apollo.entities.UserEntity;
import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.stereotype.Service;

@Service
public class KafkaConsumerService {

    @KafkaListener(topics = "users", groupId = "notification-group", containerFactory = "kafkaListenerContainerFactory")
    public void listen(UserEntity user) {
        System.out.println("Received User: " + user);
    }
}
