package com.apollo.entities;

import lombok.Data;
import lombok.experimental.Accessors;

@Data
@Accessors(chain = true)
public class LlamaResponse {
    private String message;

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }
}