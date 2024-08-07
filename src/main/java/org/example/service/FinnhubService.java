package org.example.service;

import org.example.dto.FinnhubStockQuoteDTO;
import org.example.dto.StockQuoteDTO;
import org.example.mapper.StockQuoteMapper;
import org.example.model.StockQuote;
import org.example.repository.StockQuoteRepository;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

@Service
public class FinnhubService {

    private static final Logger logger = LoggerFactory.getLogger(FinnhubService.class);

    private final RestTemplate restTemplate;
    private final String apiKey;
    private final String baseUrl;
    private final StockQuoteRepository stockQuoteRepository;

    public FinnhubService(RestTemplate restTemplate,
                          @Value("${finnhub.apikey}") String apiKey,
                          @Value("${finnhub.baseurl}") String baseUrl,
                          StockQuoteRepository stockQuoteRepository) {
        this.restTemplate = restTemplate;
        this.apiKey = apiKey;
        this.baseUrl = baseUrl;
        this.stockQuoteRepository = stockQuoteRepository;
    }

    public StockQuote updateStockQuoteEntity(String symbol) {
        String url = String.format("%s/quote?symbol=%s&token=%s", baseUrl, symbol, apiKey);
        try {
            FinnhubStockQuoteDTO finnhubStockQuoteDTO = restTemplate.getForObject(url, FinnhubStockQuoteDTO.class);
            if (finnhubStockQuoteDTO != null) {
                StockQuote stockQuote = stockQuoteRepository.findBySymbol(symbol);
                if (stockQuote == null) {
                    throw new RuntimeException("StockQuote not found for symbol " + symbol);
                }

                stockQuote.setCurrentPrice(finnhubStockQuoteDTO.getCurrentPrice());
                stockQuote.setChange(finnhubStockQuoteDTO.getChange());
                stockQuote.setPercentChange(finnhubStockQuoteDTO.getPercentChange());
                stockQuote.setHighPrice(finnhubStockQuoteDTO.getHighPrice());
                stockQuote.setLowPrice(finnhubStockQuoteDTO.getLowPrice());
                stockQuote.setOpenPrice(finnhubStockQuoteDTO.getOpenPrice());
                stockQuote.setPreviousClosePrice(finnhubStockQuoteDTO.getPreviousClosePrice());
                stockQuote.setTimestamp(finnhubStockQuoteDTO.getTimestamp());

                return stockQuoteRepository.save(stockQuote);
            } else {
                throw new RuntimeException("Failed to fetch stock quote for " + symbol);
            }
        } catch (Exception e) {
            logger.error("Error updating stock from Finnhub", e);
            throw new RuntimeException("Error updating stock from Finnhub", e);
        }
    }

    public String marketStatus() {
        String url = String.format("%s/stock/market-status?exchange=US&token=%s", baseUrl, apiKey);
        return restTemplate.getForObject(url, String.class);
    }

    public String fetchStockQuote(String symbol) {
        String url = String.format("%s/quote?symbol=%s&token=%s", baseUrl, symbol, apiKey);
        return restTemplate.getForObject(url, String.class);
    }
}