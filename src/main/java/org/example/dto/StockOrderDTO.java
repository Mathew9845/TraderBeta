package org.example.dto;

import org.example.model.UserStock;

import javax.validation.constraints.NotEmpty;
import java.math.BigDecimal;

public class StockOrderDTO {
    @NotEmpty(message = "Symbol is required")
    private String symbol;

    @NotEmpty(message = "User id is required")
    private long user_id;
    @NotEmpty(message = "Quantity is required")
    private long quantity;
    @NotEmpty(message = "Price per share is required")
    private BigDecimal pricePerShare;
    @NotEmpty(message = "Order type is required")
    private UserStock.OrderType orderType;

    public long getUser_id() {
        return user_id;
    }

    public void setUser_id(int user_id) {
        this.user_id = user_id;
    }

    public String getSymbol() {
        return symbol;
    }

    public void setSymbol(String symbol) {
        this.symbol = symbol;
    }

    public long getQuantity() {
        return quantity;
    }

    public void setQuantity(long quantity) {
        this.quantity = quantity;
    }

    public UserStock.OrderType getOrderType() {
        return orderType;
    }

    public void setOrderType(UserStock.OrderType orderType) {
        this.orderType = orderType;
    }

    public BigDecimal getPricePerShare() {
        return pricePerShare;
    }

    public void setPricePerShare(BigDecimal pricePerShare) {
        this.pricePerShare = pricePerShare;
    }
}

