package com.example.eCommerce.repository;

import com.example.eCommerce.model.Order;
import org.springframework.data.mongodb.repository.MongoRepository;

import java.util.List;
import java.util.Optional;

public interface OrderRepository extends MongoRepository<Order, String> {
    Optional<Order> findById(String orderId);
    List<Order> findByUserId(String userId);
}
