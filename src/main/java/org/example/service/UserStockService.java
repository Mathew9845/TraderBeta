package org.example.service;

import org.example.dto.StockOrderDTO;
import org.example.model.User;
import org.example.model.UserStock;
import org.example.model.Stock;
import org.example.repository.UserRepository;
import org.example.repository.StockRepository;
import org.example.repository.UserStockRepository;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;

import java.math.BigDecimal;
import java.time.LocalDateTime;

@Service
public class UserStockService {

    private static final Logger logger = LoggerFactory.getLogger(UserStockService.class);
    private final UserStockRepository userStockRepository;
    private final StockRepository stockRepository;
    private final UserRepository userRepository;

    public UserStockService(UserStockRepository userStockRepository, StockRepository stockRepository, UserRepository userRepository) {
        this.userStockRepository = userStockRepository;
        this.stockRepository = stockRepository;
        this.userRepository = userRepository;
    }

    public boolean isSymbolExist(String symbol) {
        return stockRepository.existsBySymbol(symbol);
    }

    public UserStock addStock(StockOrderDTO stockOrderDTO) {
        if (stockOrderDTO == null) {
            throw new IllegalArgumentException("Stock order data cannot be null");
        }

        if (stockOrderDTO.getQuantity() <= 0) {
            throw new IllegalArgumentException("Order quantity must be positive");
        }

        if (!isSymbolExist(stockOrderDTO.getSymbol())) {
            throw new IllegalArgumentException("Stock symbol does not exist");
        }

        try {
            // Fetch the User entity
            User user = userRepository.findById(stockOrderDTO.getUser_id())
                    .orElseThrow(() -> new IllegalArgumentException("User not found"));

            // Fetch the Stock entity
            Stock stock = stockRepository.findBySymbol(stockOrderDTO.getSymbol())
                    .orElseThrow(() -> new IllegalArgumentException("Stock symbol does not exist"));

            // Create new UserStock entity
            UserStock userStock = new UserStock();
            userStock.setUser(user);  // Set the User entity
            userStock.setStock(stock);  // Set the Stock entity
            userStock.setNumberOfShares(stockOrderDTO.getQuantity());
            userStock.setPricePerShare(stockOrderDTO.getPricePerShare());
            userStock.setTotalAmount(stockOrderDTO.getPricePerShare().multiply(BigDecimal.valueOf(stockOrderDTO.getQuantity())));
            userStock.setOrderType(stockOrderDTO.getOrderType());
            userStock.setOrderTime(LocalDateTime.now());

            return userStockRepository.save(userStock);
        } catch (Exception e) {
            logger.error("Error adding stock", e);
            throw new RuntimeException("An error occurred while adding the stock", e);
        }
    }
}
