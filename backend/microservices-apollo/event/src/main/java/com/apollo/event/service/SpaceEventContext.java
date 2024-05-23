package com.apollo.event.service;

import com.apollo.event.entity.EventEntity;
import com.apollo.event.entity.SpaceEvent;

import java.util.List;

public class SpaceEventContext {
    public SpaceEventStrategy strategy;


    public void setStrategy(SpaceEventStrategy strategy) {
        this.strategy = strategy;
    }

    public List<EventEntity> getEvents(){
        return strategy.getEventsFromExternalApi();
    }

    public List<EventEntity> getEventsByID(Integer id) {
        return strategy.getAndSaveEventsByIdFromExternalApi(id);
    }

}
