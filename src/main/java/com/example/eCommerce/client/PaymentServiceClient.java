package com.example.eCommerce.client;

import com.example.eCommerce.dto.PaymentRequest;
import com.example.eCommerce.model.Payment;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;

import java.time.Instant;
import java.time.LocalDateTime;
import java.util.UUID;

@Component
@RequiredArgsConstructor
public class PaymentServiceClient {


    public Payment createPayment(PaymentRequest request) {
        Payment payment = new Payment();
        payment.setOrderId(request.getOrderId());
        payment.setAmount(request.getAmount());
        payment.setPaymentId("mock_" + UUID.randomUUID());
        payment.setStatus("CREATED");
        payment.setCreatedAt(Instant.now());
        return payment;
    }


    public Payment markPaymentSuccess(String paymentId) {
        Payment payment = new Payment();
        payment.setPaymentId(paymentId);
        payment.setStatus("SUCCESS");
        payment.setCreatedAt(Instant.now());
        return payment;
    }
}
