package com.apollo.controllers;


import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RestController;

import com.apollo.entities.SubscriberEntity;
import com.apollo.entities.UserEntity;
import com.apollo.repositories.SubscriberRepository;
import com.apollo.repositories.UserRepository;

import lombok.AllArgsConstructor;

import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PatchMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.PathVariable;




@RestController
@AllArgsConstructor
public class UserController {

    private UserRepository userRepo;
    private SubscriberRepository subscriberRepo;

    @GetMapping("/users")
    public List<UserEntity> getUsers() {
        List<UserEntity> userlist = userRepo.findAll();
        return userlist;
    } 


    @PostMapping("/users")
    public ResponseEntity<UserEntity> createUser(@RequestBody UserEntity user) {
        UserEntity usersaved = userRepo.save(user);
        return new ResponseEntity<>(usersaved,HttpStatus.CREATED);
    }

    @PutMapping("users/{id}")
    public ResponseEntity<UserEntity> modifyUser(@PathVariable("id") Long id, @RequestBody UserEntity user) {
        UserEntity userfound = userRepo.findById(id).orElse(null);
        if(userfound!=null){
            user.setIdUser(id);
            userRepo.save(user);
            return new ResponseEntity<>(user,HttpStatus.OK);
        }else{
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }

    @PatchMapping("users/{id}")
    public ResponseEntity<UserEntity> modifyPartiallyUser(@PathVariable("id") Long id, @RequestBody UserEntity user) {
        UserEntity userfound = userRepo.findById(id).orElse(null);
        if(userfound!=null){
            Optional.ofNullable(user.getUsername()).ifPresent(userfound::setUsername);
            Optional.ofNullable(user.getEmail()).ifPresent(userfound::setEmail);
            Optional.ofNullable(user.getFullname()).ifPresent(userfound::setFullname);
            Optional.ofNullable(user.getData()).ifPresent(userfound::setData);
            userRepo.save(userfound);
            return new ResponseEntity<>(userfound,HttpStatus.OK);
        }else{
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }

    @PostMapping("users/subscribe/{region}")
    public ResponseEntity<String> subscribe(@PathVariable("region") String region,@RequestBody UserEntity user) {
        UserEntity userfound = userRepo.findById(user.getIdUser()).orElse(null);
        SubscriberEntity subscriber = SubscriberEntity.builder().region(region).email(userfound.getEmail()).build();
        subscriberRepo.save(subscriber);
        return new ResponseEntity<>("user subscribed successfully",HttpStatus.CREATED);
    }
    

    @DeleteMapping(path = "/users/{id}")
    public ResponseEntity<String> deleteUser(@PathVariable("id") Long id) {
        userRepo.deleteById(id);
        return new ResponseEntity<>("user deleted successfully",HttpStatus.OK);
    }
    
    
}
