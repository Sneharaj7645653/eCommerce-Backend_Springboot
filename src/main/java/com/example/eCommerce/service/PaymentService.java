package com.example.eCommerce.service;

import com.example.eCommerce.client.PaymentServiceClient;
import com.example.eCommerce.dto.PaymentRequest;
import com.example.eCommerce.model.Order;
import com.example.eCommerce.model.Payment;
import com.example.eCommerce.repository.OrderRepository;
import com.example.eCommerce.repository.PaymentRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class PaymentService {

    private final PaymentServiceClient paymentClient;
    private final PaymentRepository paymentRepository;
    private final OrderRepository orderRepository;

    public Payment initiatePayment(PaymentRequest request) {
        Order order = orderRepository.findById(request.getOrderId())
                .orElseThrow(() -> new RuntimeException("Order not found"));

        request.setAmount(order.getTotalAmount()); // ensure amount matches order
        Payment payment = paymentClient.createPayment(request);

        paymentRepository.save(payment);
        return payment;
    }

    public void markPaymentSuccess(String paymentId) {
        Payment payment = paymentRepository.findByPaymentId(paymentId)
                .orElseThrow(() -> new RuntimeException("Payment not found"));

        payment.setStatus("SUCCESS");
        paymentRepository.save(payment);

        // Update order
        Order order = orderRepository.findById(payment.getOrderId())
                .orElseThrow(() -> new RuntimeException("Order not found"));

        order.setStatus("PAID");
        orderRepository.save(order);
    }
}
