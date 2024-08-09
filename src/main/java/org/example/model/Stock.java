package org.example.model;

import javax.persistence.*;
import java.math.BigDecimal;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

import com.opencsv.bean.CsvBindByName;
import com.opencsv.bean.CsvCustomBindByName;
import org.example.util.LocalDateConverter;


@Entity
public class Stock {

    @Id
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

    public Stock() {}

    // Constructor with parameters
    public Stock(String symbol, String name) {
        this.symbol = symbol;
        this.name = name;
    }

    public Stock(String symbol, String name, String exchange, LocalDate ipoDate, LocalDate delistingDate, String status) {
        this.symbol = symbol;
        this.name = name;
        this.exchange = exchange;
        this.ipoDate = ipoDate;
        this.delistingDate = delistingDate;
        this.status = status;
    }

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

}
