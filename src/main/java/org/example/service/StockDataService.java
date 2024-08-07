package org.example.service;

import com.opencsv.bean.CsvToBeanBuilder;
import org.example.model.Stock;
import org.example.model.StockQuote;
import org.example.repository.StockQuoteRepository;
import org.example.repository.StockRepository;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.core.io.Resource;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import javax.annotation.PostConstruct;
import java.io.InputStreamReader;
import java.io.Reader;
import java.util.List;

@Service
public class StockDataService {

    private static final Logger log = LoggerFactory.getLogger(StockDataService.class);

    @Autowired
    private StockRepository stockRepository;

    @Autowired
    private StockQuoteRepository stockQuoteRepository; // Ensure you have this repository

    private final FinnhubService finnhubService;

    @Value("classpath:stocks.csv") // Assuming your CSV file is named stocks.csv
    private Resource stocksCsv;

    public StockDataService(FinnhubService finnhubService) {
        this.finnhubService = finnhubService;
    }


    //Load stock data from  csv to stock table and adding symbols to stockquote table
    @PostConstruct
    @Transactional
    public void loadStocksData() {
        log.info("Starting to load stock data from CSV");
        try (Reader reader = new InputStreamReader(stocksCsv.getInputStream())) {
            List<Stock> stocks = new CsvToBeanBuilder<Stock>(reader)
                    .withType(Stock.class)
                    .build()
                    .parse();
            for (Stock stock : stocks) {
                if (!stockRepository.existsBySymbol(stock.getSymbol())) {
                    Stock savedStock = stockRepository.save(stock);
                    // Optionally, immediately create a corresponding StockQuote entry
                    createInitialStockQuote(savedStock);
                } else {
                    log.info("Stock with symbol {} already exists, skipping.", stock.getSymbol());
                }
            }
            log.info("Stocks loaded successfully.");
        } catch (Exception e) {
            log.error("Failed to load stocks data from CSV.", e);
        }
    }
    private void createInitialStockQuote(Stock stock) {
        StockQuote stockQuote = new StockQuote();
        stockQuote.setSymbol(stock.getSymbol());
        // Set an initial price, this should be updated based on your application's requirements
        stockQuoteRepository.save(stockQuote);
        log.info("Initial StockQuote created for symbol: {}", stock.getSymbol());
    }

}
