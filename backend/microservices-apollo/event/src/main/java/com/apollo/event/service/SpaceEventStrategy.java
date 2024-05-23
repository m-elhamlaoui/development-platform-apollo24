package com.apollo.event.service;

import com.apollo.event.entity.EventEntity;

import java.util.List;

public interface SpaceEventStrategy {
    List<EventEntity> getEventsFromExternalApi();
    List<EventEntity> getAndSaveEventsByIdFromExternalApi(Integer id);

}
