package com.apollo.entities;

import com.apollo.entities.UserEntity;

import lombok.Data;

import java.util.Date;
import java.util.List;

@Data
public class ResponseHandler {

    private Integer id;
    private String name;
    private String description;
    private String location;
    private Date date;
    private String news_url;
    private String video_url;
    private String feature_image;
}
