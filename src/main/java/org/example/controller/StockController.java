package org.example.controller;

import org.example.model.StockQuote;
import org.example.repository.StockQuoteRepository;
import org.example.service.AlphaVantageService;
import org.example.service.FinnhubService;
import org.example.service.StockService; // Make sure this service is implemented
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

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

    @GetMapping("/finnhub/{symbol}")
    public ResponseEntity<String> getFinnhubStockData(@PathVariable String symbol) {
        return ResponseEntity.ok(finnhubService.fetchStockQuote(symbol));
    }

    @GetMapping("/marketstatus/")
    public ResponseEntity<String> checkMarketStatus() {
        return ResponseEntity.ok(finnhubService.marketStatus());
    }

    @PostMapping("/update/finnhub/{symbol}")
    public ResponseEntity<String> updateStockFromFinnhub(@PathVariable String symbol) {
        try {
            StockQuote updatedStock = finnhubService.updateStockQuoteEntity(symbol);
            return ResponseEntity.ok("Stock updated: " + updatedStock.getSymbol());
        } catch (Exception e) {
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body("Error updating stock from Finnhub");
        }
    }

}
