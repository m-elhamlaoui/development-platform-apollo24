package com.apollo.entities;

import java.util.List;

import lombok.Data;

@Data
public class ListEvent {
    private List<ResponseHandler> events;
}
