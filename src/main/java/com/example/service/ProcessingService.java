package com.example.service;

import jakarta.inject.Singleton;

@Singleton
public class ProcessingService {

    public String getTitle(String title) {
        return "Fun with the title - " + title;
    }
}
