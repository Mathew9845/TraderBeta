package org.example.controller;

import org.example.dto.StockOrderDTO;
import org.example.service.UserService;
import org.example.service.UserStockService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/stocks/")
public class UserStockController {

    private final UserStockService userStockService;

    public UserStockController(UserStockService userStockService) {
        this.userStockService = userStockService;

    }

    @PostMapping("/order/")
    public ResponseEntity<String> stockOrder(@RequestBody StockOrderDTO stockOrderDTO){
        userStockService.addStock(stockOrderDTO);
        return ResponseEntity.ok("Order placed");
    }
}
