package com.apollo.event.entity;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import java.util.Date;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder

@Document(collection = "event")
@JsonIgnoreProperties(ignoreUnknown = true)
public class EventEntity implements SpaceEvent {

    @Id
    private Integer id;
    private String name;
    private String description;
    private String location;
    private Date date;
    private String news_url;
    private String video_url;
    private String feature_image;
}
