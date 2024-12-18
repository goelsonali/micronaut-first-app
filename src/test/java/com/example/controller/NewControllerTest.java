package com.example.controller;

import io.micronaut.http.HttpRequest;
import io.micronaut.http.client.HttpClient;
import io.micronaut.http.client.annotation.Client;
import io.micronaut.runtime.server.EmbeddedServer;
import io.micronaut.test.extensions.junit5.annotation.MicronautTest;
import jakarta.inject.Inject;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

@MicronautTest
public class NewControllerTest {

    @Inject
    EmbeddedServer testServer;

    @Inject
    @Client("/")
    HttpClient client;

    @Test
    void testNewControllerResponse() {
        String response = client.toBlocking()
                .retrieve(HttpRequest.GET("/api/v1/details"));
        String expected = "You are - Sonali in city - London";
        assertEquals(expected, response);
    }

}
