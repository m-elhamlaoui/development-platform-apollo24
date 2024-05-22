package com.apollo.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import com.apollo.entities.NotificationEntity;


@Repository
public interface NotificationRepository extends JpaRepository<NotificationEntity,Long> {
    
} 