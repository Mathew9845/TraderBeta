package org.example.service;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

@Service
public class AlphaVantageService {

    private final RestTemplate restTemplate;
    private final String apiKey;
    private final String baseUrl;

    public AlphaVantageService(RestTemplate restTemplate,
                               @Value("${alphavantage.apikey}") String apiKey,
                               @Value("${alphavantage.baseurl}") String baseUrl) {
        this.restTemplate = restTemplate;
        this.apiKey = apiKey;
        this.baseUrl = baseUrl;
    }

    public String fetchStockData(String symbol) {
        String url = String.format("%s?function=TIME_SERIES_DAILY&symbol=%s&apikey=%s", baseUrl, symbol, apiKey);
        return restTemplate.getForObject(url, String.class);
    }
}