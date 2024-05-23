package com.apollo.controllers;

import org.springframework.web.bind.annotation.RestController;

import com.apollo.entities.NotificationEntity;
import com.apollo.repositories.NotificationRepository;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PatchMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;


@RestController
public class NotificationController {

    @Autowired
    private NotificationRepository notificationRepo;

    @GetMapping("/notification")
    public List<NotificationEntity> getAllNotifications() {
        List<NotificationEntity> notifications = notificationRepo.findAll();
        return notifications;
    }

    @GetMapping("/notification/{notificationid}")
    public List<NotificationEntity> getNotificationsnotification(@RequestParam Long userid) {
        List<NotificationEntity> notifications = notificationRepo.findByUserid(userid);
        return notifications;
    }
    @PostMapping("/notifications")
    public ResponseEntity<NotificationEntity> createNotification(@RequestBody NotificationEntity notification) {
        NotificationEntity notificationsaved = notificationRepo.save(notification);
        return new ResponseEntity<>(notificationsaved,HttpStatus.CREATED);
    }

    @PutMapping("notifications/{id}")
    public ResponseEntity<NotificationEntity> modifynotification(@PathVariable("id") Long id, @RequestBody NotificationEntity notification) {
        NotificationEntity notificationfound = notificationRepo.findById(id).orElse(null);
        if(notificationfound!=null){
            notification.setId(id);
            notificationRepo.save(notification);
            return new ResponseEntity<>(notification,HttpStatus.OK);
        }else{
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }

    @PatchMapping("notifications/{id}")
    public ResponseEntity<NotificationEntity> modifyPartiallynotification(@PathVariable("id") Long id, @RequestBody NotificationEntity notification) {
        NotificationEntity notificationfound = notificationRepo.findById(id).orElse(null);
        if(notificationfound!=null){
            Optional.ofNullable(notification.getMessage()).ifPresent(notificationfound::setMessage);
            Optional.ofNullable(notification.getCreatedAt()).ifPresent(notificationfound::setCreatedAt);
            Optional.ofNullable(notification.getTitle()).ifPresent(notificationfound::setTitle);
            Optional.ofNullable(notification.getUrl()).ifPresent(notificationfound::setUrl);
            Optional.ofNullable(notification.isRead()).ifPresent(notificationfound::setRead);
            notificationRepo.save(notificationfound);
            return new ResponseEntity<>(notificationfound,HttpStatus.OK);
        }else{
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }
    
    
    
}