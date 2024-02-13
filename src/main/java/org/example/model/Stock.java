package org.example.model;

import javax.persistence.*;
import java.math.BigDecimal;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;
import com.opencsv.bean.CsvBindByName;
import com.opencsv.bean.CsvCustomBindByName;
import org.example.util.LocalDateConverter;


@Entity
public class Stock {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(unique = true)
    @CsvBindByName
    private String symbol;

    @CsvBindByName
    private String name;

    @CsvBindByName
    private String exchange;

    @CsvCustomBindByName(converter = LocalDateConverter.class)
    private LocalDate ipoDate;

    @CsvCustomBindByName(converter = LocalDateConverter.class)
    private LocalDate delistingDate;

    @CsvBindByName
    private String status;


    @OneToMany(mappedBy = "stock")
    private List<UserStock> userStocks = new ArrayList<>();

    @OneToOne( mappedBy = "stock", cascade = CascadeType.ALL, fetch = FetchType.LAZY, optional = true)
    private StockQuote stockQuote;


    // Default constructor
    public Stock() {}

    // Constructor with parameters
    public Stock(String symbol, String name) {
        this.symbol = symbol;
        this.name = name;
    }

    public Stock(String symbol, String name, String exchange, LocalDate ipoDate, LocalDate delistingDate, String status, List<UserStock> userStocks) {
        this.symbol = symbol;
        this.name = name;
        this.exchange = exchange;
        this.ipoDate = ipoDate;
        this.delistingDate = delistingDate;
        this.status = status;
        this.userStocks = userStocks;
    }

    // Getters and Setters


    public String getSymbol() {
        return symbol;
    }

    public void setSymbol(String symbol) {
        this.symbol = symbol;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public List<UserStock> getUserStocks() {
        return userStocks;
    }

    public void setUserStocks(List<UserStock> userStocks) {
        this.userStocks = userStocks;
    }

    public String getExchange() {
        return exchange;
    }

    public void setExchange(String exchange) {
        this.exchange = exchange;
    }

    public LocalDate getIpoDate() {
        return ipoDate;
    }

    public void setIpoDate(LocalDate ipoDate) {
        this.ipoDate = ipoDate;
    }

    public LocalDate getDelistingDate() {
        return delistingDate;
    }

    public void setDelistingDate(LocalDate delistingDate) {
        this.delistingDate = delistingDate;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    // Helper methods for managing the bidirectional relationship



}
