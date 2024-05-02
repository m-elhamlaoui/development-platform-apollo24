package com.apollo.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.apollo.entities.SubscriberEntity;

@Repository
public interface SubscriberRepository extends JpaRepository<SubscriberEntity,Long> {
} 