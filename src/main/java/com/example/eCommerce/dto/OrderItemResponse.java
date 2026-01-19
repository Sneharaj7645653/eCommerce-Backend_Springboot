package com.example.eCommerce.dto;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class OrderItemResponse {

    private String productId;
    private int quantity;
    private double price;
}
