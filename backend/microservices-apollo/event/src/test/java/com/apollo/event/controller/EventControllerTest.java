package com.apollo.event.controller;

import static org.junit.jupiter.api.Assertions.*;

import com.apollo.event.entity.EventEntity;
import com.apollo.event.service.EventService;
import com.apollo.event.service.SpaceEventService;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;

import java.util.Arrays;
import java.util.List;

import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.content;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;
import static org.mockito.BDDMockito.given;

@WebMvcTest(EventController.class)
class EventControllerTest {
    @Autowired
    private MockMvc mockMvc;

    @MockBean
    private EventService eventService;

    @MockBean
    private SpaceEventService spaceEventService;

    @Test
    public void testGetEvents() throws Exception {
        EventEntity event1 = new EventEntity(1L, "Event1", "Description1", "Location1", null, "News1", "Video1", "Image1");
        EventEntity event2 = new EventEntity(2L, "Event2", "Description2", "Location2", null, "News2", "Video2", "Image2");
        List<EventEntity> allEvents = Arrays.asList(event1, event2);

        given(eventService.getEventsFromExternalApi()).willReturn(allEvents);

        this.mockMvc.perform(get("/events"))
                .andExpect(status().isOk())
                .andExpect(content().contentType(MediaType.APPLICATION_JSON))
                .andExpect(content().json("[{\"id\":1,\"name\":\"Event1\"},{\"id\":2,\"name\":\"Event2\"}]"));
    }

    @Test
    public void testGetSpaceEvents() throws Exception {
        EventEntity event1 = new EventEntity(1L, "SpaceEvent1", "Description1", "Location1", null, "News1", "Video1", "Image1");
        EventEntity event2 = new EventEntity(2L, "SpaceEvent2", "Description2", "Location2", null, "News2", "Video2", "Image2");
        List<EventEntity> spaceEvents = Arrays.asList(event1, event2);

        given(spaceEventService.getSpaceEvents()).willReturn(spaceEvents);

        this.mockMvc.perform(get("/strategy"))
                .andExpect(status().isOk())
                .andExpect(content().contentType(MediaType.APPLICATION_JSON))
                .andExpect(content().json("[{\"id\":1,\"name\":\"SpaceEvent1\"},{\"id\":2,\"name\":\"SpaceEvent2\"}]"));
    }

}