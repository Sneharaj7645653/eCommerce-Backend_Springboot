package com.example.eCommerce.model;


import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.RequiredArgsConstructor;
import lombok.Setter;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

@Document(collection = "order_item")
@Getter
@Setter
@NoArgsConstructor
public class OrderItem {
    @Id
    private String id;
    private String orderId;
    private String productId;
    private int quantity;
    private double price;
}
