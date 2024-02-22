package org.example.service;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

@Service
public class FinnhubService {

    private final RestTemplate restTemplate;
    private final String apiKey;
    private final String baseUrl;

    public FinnhubService(RestTemplate restTemplate,
                          @Value("${finnhub.apikey}") String apiKey,
                          @Value("${finnhub.baseurl}") String baseUrl) {
        this.restTemplate = restTemplate;
        this.apiKey = apiKey;
        this.baseUrl = baseUrl;
    }

    public String fetchStockQuote(String symbol) {
        String url = String.format("%s/quote?symbol=%s&token=%s", baseUrl, symbol, apiKey);
        return restTemplate.getForObject(url, String.class);
    }

    public String marketStatus(){
        String url = String.format("%s/stock/market-status?exchange=US&token=%s",baseUrl, apiKey);
        System.out.println("Requesting URL: " + url); // Consider using a logger
        return restTemplate.getForObject(url, String.class);

    }






}
