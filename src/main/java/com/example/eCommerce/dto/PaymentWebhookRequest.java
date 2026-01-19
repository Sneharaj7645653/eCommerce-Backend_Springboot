package com.example.eCommerce.dto;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class PaymentWebhookRequest {

    private String paymentId;
    private String status;
}
