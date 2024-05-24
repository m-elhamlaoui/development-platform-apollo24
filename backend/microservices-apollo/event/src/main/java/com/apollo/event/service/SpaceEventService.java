package com.apollo.event.service;

import com.apollo.event.entity.EventEntity;
import com.apollo.event.repository.EventRepository;
import com.apollo.event.service.strategy.GenericEventStrategy;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class SpaceEventService {
    private final EventRepository eventRepository;

    SpaceEventContext context = new SpaceEventContext();

    public SpaceEventService(EventRepository eventRepository) {
        this.eventRepository = eventRepository;
    }

    public List<EventEntity> getSpaceEvents(){
        SpaceEventStrategy strategy = new GenericEventStrategy();
        context.setStrategy(strategy);

        return context.getEvents();
    }

    public List<EventEntity> findAll() {
        return eventRepository.findAll();
    }

    public  List<EventEntity> fetchEventById(Integer id){
        SpaceEventStrategy strategy = new GenericEventStrategy();
        context.setStrategy(strategy);

        // Save filtered events to MongoDB
        List<EventEntity> eventsToSave = context.getEventsByID(id);

        return eventsToSave;
    }

    public List<EventEntity>  saveEventById(Integer id) {
        // Assuming your API provides a method to fetch an event by its ID
        List<EventEntity> event = fetchEventById(id);
        if (event != null) {
            // Save the event to MongoDB
            return eventRepository.saveAll(event);

        } else {
            // Handle case where event with given ID is not found
            throw new RuntimeException("Event with ID " + id + " not found.");
        }
    }

    public Optional<EventEntity> getSpaceEventById(Integer id){
        return eventRepository.findById(id);
    }

}
