package com.gzpr.testTask.services;

import com.gzpr.testTask.Models.ApiResponse;
import org.springframework.boot.web.client.RestTemplateBuilder;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;
import org.springframework.web.util.UriComponentsBuilder;

import java.time.Duration;

@Service
public class RestService {

    private static final String SCHEME = "https";
    private static final String HOST = "randomuser.me";
    private static final String PATH = "/api";
    private static final String QUERYPARAMRESULTS = "results";
    private static final String QUERYPARAMINC = "inc";
    private static final String FIELDS = "gender,name,email";

    private final RestTemplate restTemplate;

    public RestService(RestTemplateBuilder restTemplateBuilder) {
        // set connection and read timeouts
        this.restTemplate = restTemplateBuilder
                .setConnectTimeout(Duration.ofSeconds(500))
                .setReadTimeout(Duration.ofSeconds(500))
                .build();
    }

    public ApiResponse getJSON(final String numberOfRows) {

        final String url = UriComponentsBuilder.newInstance()
                .scheme(SCHEME)
                .host(HOST)
                .path(PATH)
                .queryParam(QUERYPARAMINC, FIELDS)
                .queryParam(QUERYPARAMRESULTS, numberOfRows)
                .build()
                .toUriString();

        ResponseEntity<ApiResponse> response = this.restTemplate.getForEntity(url, ApiResponse.class);
        if (response.getStatusCode() == HttpStatus.OK) {
            return response.getBody();
        } else {
            return null;
        }
    }
}
