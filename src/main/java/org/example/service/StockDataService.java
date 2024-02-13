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

    @Value("classpath:stocks.csv") // Assuming your CSV file is named stocks.csv
    private Resource stocksCsv;


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
                } else {
                    log.info("Stock with symbol {} already exists, skipping.", stock.getSymbol());
                }
            }

            log.info("Stocks and their corresponding StockQuotes loaded successfully.");
        } catch (Exception e) {
            log.error("Failed to load stocks and stock quotes data from CSV.", e);
        }
    }




}
