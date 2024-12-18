package com.example.service;

import com.example.custom.LogExecution;
import jakarta.inject.Singleton;

@Singleton
public class NewService {

    @LogExecution
    public String getResult(String name, String city) {
        System.out.println("Name & city provided");
        return "You are - " + name + " in city - " + city;
    }
}
