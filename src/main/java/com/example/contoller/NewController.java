package com.example.contoller;

import com.example.dto.DetailsResponse;
import com.example.service.NewService;
import com.example.service.ProcessingService;
import io.micronaut.http.HttpResponse;
import io.micronaut.http.MediaType;
import io.micronaut.http.annotation.Controller;
import io.micronaut.http.annotation.Get;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
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


    @Get(uri ="/details", produces = MediaType.APPLICATION_JSON)
    @ApiResponse(responseCode = "200", description = "Successful response")
    @ApiResponse(responseCode = "400", description = "Invalid input")
    public HttpResponse<DetailsResponse> getDetails() {
        String name = "Sonali";
        String city = "London";
        if (name == null || name.isEmpty() || city == null || city.isEmpty()) {
            return HttpResponse.badRequest(new DetailsResponse("Invalid input: name and city are required"));
        }
        return HttpResponse.ok(new DetailsResponse(newService.getResult(name, city)));
    }

    @Get(uri ="/title", produces = MediaType.APPLICATION_JSON)
    @ApiResponse(responseCode = "200", description = "Successful response")
    @ApiResponse(responseCode = "400", description = "Invalid input")
    public HttpResponse<DetailsResponse> getTitle() {
        String title = processingService.getTitle("Price service");
        if (title == null || title.isEmpty()) {
            return HttpResponse.badRequest(new DetailsResponse("Title not found"));
        }
        return HttpResponse.ok(new DetailsResponse(title));
    }

}
