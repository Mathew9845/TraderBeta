package org.example.controller;

// Import statements to include classes from other packages
import org.example.service.AlphaVantageService;
import org.example.service.FinnhubService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

// Marks this class as a Rest Controller, making it capable of handling HTTP requests.
@RestController
// Defines the base URL path for all methods in this controller.
@RequestMapping("/api/stocks")
public class StockController {

    // Declares references to AlphaVantageService and FinnhubService.
    private final AlphaVantageService alphaVantageService;
    private final FinnhubService finnhubService;

    // Constructor for dependency injection. Spring automatically injects instances of AlphaVantageService and FinnhubService.
    @Autowired
    public StockController(AlphaVantageService alphaVantageService, FinnhubService finnhubService) {
        this.alphaVantageService = alphaVantageService;
        this.finnhubService = finnhubService;
    }

    // Handles GET requests to /api/stocks/alpha/{symbol}. The {symbol} is a path variable.
    @GetMapping("/alpha/{symbol}")
    public String getAlphaVantageStockData(@PathVariable String symbol) {
        // Fetches stock data for the given symbol using AlphaVantageService and returns it.
        return alphaVantageService.fetchStockData(symbol);
    }

    // Handles GET requests to /api/stocks/finnhub/{symbol}. Similar to the AlphaVantage method, but uses FinnhubService.
    @GetMapping("/finnhub/{symbol}")
    public String getFinnhubStockData(@PathVariable String symbol) {
        // Fetches stock data for the given symbol using FinnhubService and returns it.
        return finnhubService.fetchStockData(symbol);
    }
}
