package com.gzpr.testTask.services.impl;

import com.gzpr.testTask.Models.ApiResponse;
import com.gzpr.testTask.services.RestService;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.web.client.RestTemplateBuilder;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;
import org.springframework.web.util.UriComponentsBuilder;

import java.time.Duration;

@Service
public class DefaultRestService implements RestService {
    @Value("${scheme}")
    private String SCHEME;
    @Value("${host}")
    private String HOST;
    @Value("${urlpath}")
    private String PATH;
    @Value("${queryparamresults}")
    private String QUERYPARAMRESULTS;
    @Value("${queryparaminc}")
    private String QUERYPARAMINC;
    @Value("${fields}")
    private String FIELDS;

    private final RestTemplate restTemplate;

    public DefaultRestService(RestTemplateBuilder restTemplateBuilder) {
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
