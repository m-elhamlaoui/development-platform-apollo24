package com.apollo.service;

import com.apollo.entities.UserEntity;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.stereotype.Service;

@Service
public class KafkaProducerService {

    private static final String TOPIC = "users";

    @Autowired
    private KafkaTemplate<String, UserEntity> kafkaTemplate;

    public void sendMessage(UserEntity user) {
        kafkaTemplate.send(TOPIC, user);
    }
}
