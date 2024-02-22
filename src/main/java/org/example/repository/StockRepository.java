package org.example.repository;

import org.example.model.Stock;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface StockRepository extends JpaRepository<Stock, Long> {
    boolean existsBySymbol(String symbol);

    Optional<Stock> findBySymbol(String symbol);
}
