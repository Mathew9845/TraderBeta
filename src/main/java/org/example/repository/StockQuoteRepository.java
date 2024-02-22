package org.example.repository;

import org.example.model.Stock;
import org.example.model.StockQuote;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface StockQuoteRepository extends JpaRepository<StockQuote, Long> {
    Optional<StockQuote> findBySymbol(String symbol);
    // Basic CRUD operations are inherited from JpaRepository

    // Example of a custom query method

    // Method to check if a Stock with a given symbol exists

}
