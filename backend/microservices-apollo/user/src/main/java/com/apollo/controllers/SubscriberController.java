package com.apollo.controllers;


import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RestController;

import com.apollo.entities.SubscriberEntity;
import com.apollo.repositories.SubscriberRepository;

import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PatchMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.PathVariable;




@RestController
public class SubscriberController {

    @Autowired
    private SubscriberRepository subscriberRepo;

    @GetMapping("/subscribers")
    public List<SubscriberEntity> getSubscribers() {
        List<SubscriberEntity> subscriberlist = subscriberRepo.findAll();
        return subscriberlist;
    } 


    @PostMapping("/subscribers")
    public ResponseEntity<SubscriberEntity> createSubscriber(@RequestBody SubscriberEntity subscriber) {
        SubscriberEntity subscribersaved = subscriberRepo.save(subscriber);
        return new ResponseEntity<>(subscribersaved,HttpStatus.CREATED);
    }

    @PutMapping("subscribers/{id}")
    public ResponseEntity<SubscriberEntity> modifySubscriber(@PathVariable("id") Long id,
                                                            @RequestBody SubscriberEntity subscriber) {
        SubscriberEntity subscriberfound = subscriberRepo.findById(id).orElse(null);
        if(subscriberfound!=null){
            subscriber.setIdSubscriber(id);
            subscriberRepo.save(subscriber);
            return new ResponseEntity<>(subscriber,HttpStatus.OK);
        }else{
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }

    @PatchMapping("subscribers/{id}")
    public ResponseEntity<SubscriberEntity> modifyPartiallySubscriber(@PathVariable("id") Long id, 
                                                                      @RequestBody SubscriberEntity subscriber) {
        SubscriberEntity subscriberfound = subscriberRepo.findById(id).orElse(null);
        if(subscriberfound!=null){
            Optional.ofNullable(subscriber.getEmail()).ifPresent(subscriberfound::setEmail);
            subscriberRepo.save(subscriberfound);
            return new ResponseEntity<>(subscriberfound,HttpStatus.OK);
        }else{
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }
    
    @DeleteMapping(path = "/subscribers/{id}")
    public ResponseEntity<String> unsubscribe(@PathVariable("id") Long id) {
        subscriberRepo.deleteById(id);
        return new ResponseEntity<>("subscriber deleted succesfully",HttpStatus.OK);
    }
    
    
}
