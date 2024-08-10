package org.example.repository;

import org.example.model.UserStock;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UserStockRepository extends JpaRepository<UserStock, Long> {

}
