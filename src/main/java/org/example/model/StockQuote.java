package org.example.model;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.opencsv.bean.CsvBindByName;

import javax.persistence.*;

@Entity
public class StockQuote {

    @Id
    @Column(unique = true)
    private String symbol; // Primary key, also serving as FK to Stock

    private Double currentPrice;

    private Double change;

    private Double percentChange;

    private Double highPrice;

    private Double lowPrice;

    private Double openPrice;

    private Double previousClosePrice;

    private Long timestamp;


//    @OneToOne
//    @JoinColumn(name = "symbol",referencedColumnName = "symbol", nullable = false)
//    private Stock stock;



    // Constructors, Getters, and Setters

    public StockQuote() {
        // Default constructor
    }

    public String getSymbol() {
        return symbol;
    }

    public void setSymbol(String symbol) {
        this.symbol = symbol;
    }

    public Double getCurrentPrice() {
        return currentPrice;
    }

    public void setCurrentPrice(Double currentPrice) {
        this.currentPrice = currentPrice;
    }

    public Double getChange() {
        return change;
    }

    public void setChange(Double change) {
        this.change = change;
    }

    public Double getPercentChange() {
        return percentChange;
    }

    public void setPercentChange(Double percentChange) {
        this.percentChange = percentChange;
    }

    public Double getHighPrice() {
        return highPrice;
    }

    public void setHighPrice(Double highPrice) {
        this.highPrice = highPrice;
    }

    public Double getLowPrice() {
        return lowPrice;
    }

    public void setLowPrice(Double lowPrice) {
        this.lowPrice = lowPrice;
    }

    public Double getOpenPrice() {
        return openPrice;
    }

    public void setOpenPrice(Double openPrice) {
        this.openPrice = openPrice;
    }

    public Double getPreviousClosePrice() {
        return previousClosePrice;
    }

    public void setPreviousClosePrice(Double previousClosePrice) {
        this.previousClosePrice = previousClosePrice;
    }

    public Long getTimestamp() {
        return timestamp;
    }

    public void setTimestamp(Long timestamp) {
        this.timestamp = timestamp;
    }

//    public Stock getStock() {
//        return stock;
//    }
//
//    public void setStock(Stock stock) {
//        this.stock = stock;
//    }
}
