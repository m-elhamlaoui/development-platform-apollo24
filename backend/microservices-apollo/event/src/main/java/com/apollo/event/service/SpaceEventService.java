package com.apollo.event.service;

import com.apollo.event.entity.EventEntity;
import com.apollo.event.entity.SpaceEvent;
import com.apollo.event.service.strategy.GenericEventStrategy;

import java.util.List;

public class SpaceEventService {

    SpaceEventContext context = new SpaceEventContext();

    public List<EventEntity> getSpaceEvents(){
        SpaceEventStrategy strategy = new GenericEventStrategy();
        context.setStrategy(strategy);

        return context.getEvents();
    }

}
