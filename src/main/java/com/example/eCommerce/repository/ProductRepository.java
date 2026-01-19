package com.example.eCommerce.repository;

import com.example.eCommerce.model.Product;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.data.mongodb.repository.Query;


import java.util.List;

public interface ProductRepository extends MongoRepository<Product, String> {
    @Query("{ $text: { $search: ?0 } }")
    List<Product> search(String query);

}
