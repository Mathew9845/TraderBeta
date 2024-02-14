package org.example.model;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.opencsv.bean.CsvBindByName;

import javax.persistence.*;
import java.math.BigDecimal;

@Entity
public class StockQuote {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(unique = true)
    @CsvBindByName
    private String symbol; // Primary key, also serving as FK to Stock

    private long StockId;

    private BigDecimal currentPrice;

    private BigDecimal change;

    private BigDecimal percentChange;

    private BigDecimal highPrice;

    private BigDecimal lowPrice;

    private BigDecimal openPrice;

    private BigDecimal previousClosePrice;


//    @ManyToOne
//    @JoinColumn(name = "stock_id", nullable = false)
//    private Stock stock;



    // Constructors, Getters, and Setters

    public StockQuote() {
        // Default constructor
    }

    // Getters and setters
    public BigDecimal getCurrentPrice() {
        return currentPrice;
    }

    public void setCurrentPrice(BigDecimal currentPrice) {
        this.currentPrice = currentPrice;
    }

    public BigDecimal getChange() {
        return change;
    }

    public void setChange(BigDecimal change) {
        this.change = change;
    }

    public BigDecimal getPercentChange() {
        return percentChange;
    }

    public void setPercentChange(BigDecimal percentChange) {
        this.percentChange = percentChange;
    }

    public BigDecimal getHighPrice() {
        return highPrice;
    }

    public void setHighPrice(BigDecimal highPrice) {
        this.highPrice = highPrice;
    }

    public BigDecimal getLowPrice() {
        return lowPrice;
    }

    public void setLowPrice(BigDecimal lowPrice) {
        this.lowPrice = lowPrice;
    }

    public BigDecimal getOpenPrice() {
        return openPrice;
    }

    public void setOpenPrice(BigDecimal openPrice) {
        this.openPrice = openPrice;
    }

    public BigDecimal getPreviousClosePrice() {
        return previousClosePrice;
    }

    public void setPreviousClosePrice(BigDecimal previousClosePrice) {
        this.previousClosePrice = previousClosePrice;
    }

    public String getSymbol() {
        return symbol;
    }

    public void setSymbol(String symbol) {
        this.symbol = symbol;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Long getStockId() {
        return StockId;
    }

    public void setStockId(int stockId) {
        StockId = stockId;
    }

    public void setStockId(Long stockId) {
    }
}
