package org.example.model;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

@Entity
public class User {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String username;
    private String email;

    @OneToMany(mappedBy = "user")
    private List<UserStock> userStocks = new ArrayList<>();

    public User() {}

    // Getters and Setters

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public List<UserStock> getUserStocks() {
        return userStocks;
    }

    public void setUserStocks(List<UserStock> userStocks) {
        this.userStocks = userStocks;
    }


    // Helper methods for managing the bidirectional relationship



}
