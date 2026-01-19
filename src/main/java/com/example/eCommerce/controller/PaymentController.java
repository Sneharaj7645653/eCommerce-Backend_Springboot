package com.example.eCommerce.controller;

import com.example.eCommerce.dto.PaymentRequest;
import com.example.eCommerce.dto.PaymentResponse;
import com.example.eCommerce.model.Payment;
import com.example.eCommerce.service.PaymentService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/payments")
@RequiredArgsConstructor
public class PaymentController {

    private final PaymentService paymentService;

    @PostMapping("/create")
    public Payment createPayment(@RequestBody PaymentRequest request) {
        return paymentService.initiatePayment(request);
    }

    @PostMapping("/mock/success")
    public void mockPaymentSuccess(@RequestParam String paymentId) {
        paymentService.markPaymentSuccess(paymentId);
    }
}

