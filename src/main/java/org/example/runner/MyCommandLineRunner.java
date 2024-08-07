package org.example.runner;

import org.example.service.StockQuoteService;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

@Component
public class MyCommandLineRunner implements CommandLineRunner {

    private final StockQuoteService stockQuoteService;

    public MyCommandLineRunner(StockQuoteService stockQuoteService) {
        this.stockQuoteService = stockQuoteService;
    }

    @Override
    public void run(String... args) throws Exception {


    }
}
