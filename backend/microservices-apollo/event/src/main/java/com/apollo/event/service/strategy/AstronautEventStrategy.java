package com.apollo.event.service.strategy;

import com.apollo.event.entity.EventEntity;
import com.apollo.event.responseApi.ResponseHandler;
import com.apollo.event.service.SpaceEventStrategy;
import org.springframework.web.client.RestTemplate;

import java.util.List;

public class AstronautEventStrategy implements SpaceEventStrategy {
    String url = "https://lldev.thespacedevs.com/2.2.0/astronaut/";
    @Override
    public List<EventEntity> getEventsFromExternalApi() {
        RestTemplate restTemplate = new RestTemplate();
        ResponseHandler response = restTemplate.getForObject(url, ResponseHandler.class);
        assert response != null;
        List<EventEntity> astronautEvents = response.getResults();
        return astronautEvents;
    }
}