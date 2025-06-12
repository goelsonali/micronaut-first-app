package com.example.contoller;

import com.example.service.NewService;
import com.example.service.ProcessingService;
import io.micronaut.http.annotation.Controller;
import io.micronaut.http.annotation.Get;
import jakarta.inject.Inject;

@Controller("/api/v1")
public class NewController {
    private final NewService newService;
    private final ProcessingService processingService;

    @Inject // This is required for the constructor injection to scan the constructor to perform dependency injection.
    public NewController(NewService newService, ProcessingService processingService)
    {
        this.newService = newService;
        this.processingService = processingService;
    }


    @Get(uri ="/details", produces = "application/json")
    public String getDetails() {
        return newService.getResult("Sonali", "London");
    }

    @Get(uri ="/title", produces = "application/json")
    public String getTitle() {
        return processingService.getTitle("Price service");
    }

}
