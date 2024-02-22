package org.example.controller;

import org.example.model.Stock;
import org.example.model.StockQuote;
import org.example.repository.StockQuoteRepository;
import org.example.service.AlphaVantageService;
import org.example.service.FinnhubService;
import org.example.service.StockService; // Make sure this service is implemented
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.Optional;

@RestController
@RequestMapping("/api/stocks")
public class StockController {


    private final StockService stockService;
    private final AlphaVantageService alphaVantageService;
    private final FinnhubService finnhubService;
    private StockQuoteRepository stockQuoteRepository;


    @Autowired
    public StockController(StockService stockService, AlphaVantageService alphaVantageService, FinnhubService finnhubService) {
        this.stockService = stockService;
        this.alphaVantageService = alphaVantageService;
        this.finnhubService = finnhubService;
    }
    // If you have specific scenarios where you always want to fetch from an external service,
    // you can still directly call those services as before:

    @GetMapping("/finnhub/{symbol}")
    public ResponseEntity<String> getFinnhubStockData(@PathVariable String symbol) {
        return ResponseEntity.ok(finnhubService.fetchStockQuote(symbol));
    }

    @GetMapping("/marketstatus/")
    public ResponseEntity<String> checkMarketStatus() {
        return ResponseEntity.ok(finnhubService.marketStatus());
    }













    // Add more endpoints as needed for other functionalities
}
