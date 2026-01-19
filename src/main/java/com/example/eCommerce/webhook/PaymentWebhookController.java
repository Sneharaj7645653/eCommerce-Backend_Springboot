package com.example.eCommerce.webhook;

import com.example.eCommerce.dto.PaymentWebhookRequest;
import com.example.eCommerce.service.PaymentService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/webhooks/payment")
@RequiredArgsConstructor
public class PaymentWebhookController {

    private final PaymentService paymentService;

    @PostMapping
    public void handleWebhook(@RequestBody PaymentWebhookRequest request) {
        if ("SUCCESS".equalsIgnoreCase(request.getStatus())) {
            paymentService.markPaymentSuccess(request.getPaymentId());
        }
    }
}
