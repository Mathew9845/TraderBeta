package org.example.repository;

import org.example.model.Stock;
import org.example.model.StockQuote;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.Optional;

//public interface StockQuoteRepository extends JpaRepository<StockQuote, String> {
//
//    // Finds a StockQuote by its symbol
//    Optional<StockQuote> findBySymbol(String symbol);
//
//    // Additional custom query methods can be defined here if needed
//}

public interface StockQuoteRepository extends JpaRepository<StockQuote, String> {

    // Custom query methods can be added here if needed
    StockQuote findBySymbol(String symbol);
}
