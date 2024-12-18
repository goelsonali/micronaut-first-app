package com.example.contoller;

import com.example.service.NewService;
import io.micronaut.http.annotation.Controller;
import io.micronaut.http.annotation.Get;
import jakarta.inject.Inject;

@Controller("/api/v1")
public class NewController {

    @Inject
    private final NewService newService;
    public NewController(NewService newService) {
        this.newService = newService;
    }


    @Get("/details")
    public String getDetails() {
        return newService.getResult("Sonali", "London");
    }



}
