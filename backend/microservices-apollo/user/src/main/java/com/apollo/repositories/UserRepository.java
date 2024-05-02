package com.apollo.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.apollo.entities.UserEntity;

@Repository
public interface UserRepository extends JpaRepository<UserEntity,Long> {
} 