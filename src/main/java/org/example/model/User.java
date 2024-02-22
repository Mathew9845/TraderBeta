package org.example.model;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

@Entity
public class User {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)

    private Long user_id;

    private String username;
    private String email;

    private String password;

    @OneToMany(mappedBy = "user")
    private Set<UserStock> userStocks;

    public User() {}

    // Getters and Setters

    public Long getUser_id() {
        return user_id;
    }

    public void setUser_id(Long user_id) {
        this.user_id = user_id;
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

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public Set<UserStock> getUserStocks() {
        return userStocks;
    }

    public void setUserStocks(Set<UserStock> userStocks) {
        this.userStocks = userStocks;
    }

    // Helper methods for managing the bidirectional relationship



}
