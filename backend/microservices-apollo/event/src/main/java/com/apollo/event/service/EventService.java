package com.apollo.event.service;

import com.apollo.event.entity.EventEntity;
import com.apollo.event.responseApi.ResponseHandler;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

@Service
public class EventService {

    private String externalApiUrl = "https://lldev.thespacedevs.com/2.2.0/event/";

    public List<EventEntity> getEventsFromExternalApi() {
        RestTemplate restTemplate = new RestTemplate();
        ResponseHandler response = restTemplate.getForObject(externalApiUrl, ResponseHandler.class);
        assert response != null;
        List<EventEntity> events = response.getResults();

        return events;
    }



}
