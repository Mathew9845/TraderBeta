package org.example.repository;

import org.example.model.StockQuote;
import org.springframework.data.jpa.repository.JpaRepository;

public interface StockQuoteRepository extends JpaRepository<StockQuote, Long> {
    // Basic CRUD operations are inherited from JpaRepository

    // Example of a custom query method

    // Method to check if a Stock with a given symbol exists

}
