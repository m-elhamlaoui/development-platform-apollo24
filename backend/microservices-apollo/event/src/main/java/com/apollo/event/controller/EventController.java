package com.apollo.event.controller;

import com.apollo.event.entity.EventEntity;
import com.apollo.event.service.EventService;
import com.apollo.event.service.SpaceEventService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping(value = "/events")
public class EventController {

    @Autowired
    private EventService eventService;
    private final SpaceEventService spaceService;

    public EventController(SpaceEventService spaceService) {
        this.spaceService = spaceService;
    }

    // Show all events from the api
    @GetMapping(value = "/events")
    public List<EventEntity> getEvents() {
        // Call your existing method to get events from the external API
        List<EventEntity> events = eventService.getEventsFromExternalApi();
        return events;
    }

    // Show all events from the api
    @GetMapping(value = "/allEvents")
    public List<EventEntity> getSpaceEvents(){
        List<EventEntity> nEvents = spaceService.getSpaceEvents();
        return nEvents;
    }

    // Show the Events Stored in the db
    @GetMapping("/findAll")
    public List<EventEntity> getEventsFromDB() {
        return spaceService.findAll();
    }

    @GetMapping("/fetchAndSave/{id}")
    public List<EventEntity> SaveEventsById(@PathVariable Integer id) {
        return spaceService.saveEventById(id);
    }

    @GetMapping("/event/{id}")
    public Optional<EventEntity> getSpaceEventById(@PathVariable Integer id) {return spaceService.getSpaceEventById(id);}
}
