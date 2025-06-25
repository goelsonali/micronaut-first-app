package com.example.dto;

import io.micronaut.serde.annotation.Serdeable;

@Serdeable
public class DetailsResponse {
    private String message;

    public DetailsResponse(String message) {
        this.message = message;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }
}
