package org.example.model;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

@Entity
public class Stock {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String symbol;
    private String name;

    @OneToMany(mappedBy = "stock")
    private List<UserStock> userStocks = new ArrayList<>();

    // Default constructor
    public Stock() {}

    // Constructor with parameters
    public Stock(String symbol, String name) {
        this.symbol = symbol;
        this.name = name;
    }

    // Getters and Setters

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
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

    public List<UserStock> getUserStocks() {
        return userStocks;
    }

    public void setUserStocks(List<UserStock> userStocks) {
        this.userStocks = userStocks;
    }


    // Helper methods for managing the bidirectional relationship



}
