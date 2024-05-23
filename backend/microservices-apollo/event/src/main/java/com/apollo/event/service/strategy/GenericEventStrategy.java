package com.apollo.event.service.strategy;

import com.apollo.event.entity.EventEntity;
import com.apollo.event.responseApi.ResponseHandler;
import com.apollo.event.service.SpaceEventStrategy;
import org.springframework.web.client.RestTemplate;

import java.util.List;
import java.util.stream.Collectors;

public class GenericEventStrategy implements SpaceEventStrategy {
    String url = "https://lldev.thespacedevs.com/2.2.0/event/";
    @Override
    public List<EventEntity> getEventsFromExternalApi() {
        RestTemplate restTemplate = new RestTemplate();
        ResponseHandler response = restTemplate.getForObject(url, ResponseHandler.class);
        assert response != null;
        List<EventEntity> events = response.getResults();
        return events;
    }

    public List<EventEntity> getAndSaveEventsByIdFromExternalApi(Integer id) {
        RestTemplate restTemplate = new RestTemplate();
        ResponseHandler response = restTemplate.getForObject(url, ResponseHandler.class);
        assert response != null;

        // Filter events by the specified ID
        List<EventEntity> eventsToSave = response.getResults().stream()
                .filter(event -> event.getId().equals(id))
                .collect(Collectors.toList());

        // Save filtered events to MongoDB
        //eventRepository.saveAll(eventsToSave);

        return eventsToSave;
    }
}
