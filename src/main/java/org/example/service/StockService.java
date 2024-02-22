package org.example.service;

import org.example.model.StockQuote;
import org.example.repository.StockQuoteRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.util.Optional;

@Service
public class StockService {

    private final StockQuoteRepository stockQuoteRepository;

    @Autowired
    public StockService(
            StockQuoteRepository stockQuoteRepository) {
        this.stockQuoteRepository = stockQuoteRepository;
    }
    public Optional<StockQuote> getStockQuoteBySymbol(String symbol) {
        return stockQuoteRepository.findBySymbol(symbol);
    }

}
