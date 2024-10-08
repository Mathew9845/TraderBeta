package org.example.repository;

import org.example.model.User;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface UserRepository extends JpaRepository<User, Long> {
    // You can add custom methods if needed
    Optional<User> findByUsername(String username);
    Optional<User> findByPassword(String password);
    Optional<User> findByEmail(String email);

}
