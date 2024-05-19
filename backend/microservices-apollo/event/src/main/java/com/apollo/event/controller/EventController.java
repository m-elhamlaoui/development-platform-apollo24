package com.apollo.event.controller;

import com.apollo.event.entity.EventEntity;
import com.apollo.event.responseApi.ResponseHandler;
import com.apollo.event.service.EventService;
import com.apollo.event.service.SpaceEventService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Objects;

@RestController
public class EventController {
    @Autowired
    private EventService eventService;
    private SpaceEventService spaceService = new SpaceEventService();

    @GetMapping(value = "/events")
    public List<EventEntity> getEvents() {
        // Call your existing method to get events from the external API
        List<EventEntity> events = eventService.getEventsFromExternalApi();
        return events;
    }

    @GetMapping(value = "/strategy")
    public List<EventEntity> getSpaceEvents(){
        List<EventEntity> nEvents = spaceService.getSpaceEvents();
        return nEvents;
    }


}
