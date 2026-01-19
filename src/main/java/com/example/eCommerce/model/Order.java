package com.example.eCommerce.model;


import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import java.time.Instant;

@Document(collection = "order")
@Getter
@Setter
@NoArgsConstructor
public class Order {
    @Id
    private String id;
    private String userId;
    private double totalAmount;
    private String status;
    private Instant createdAt;
}