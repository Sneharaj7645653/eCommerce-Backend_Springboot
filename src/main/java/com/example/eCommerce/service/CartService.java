package com.example.eCommerce.service;

import com.example.eCommerce.dto.AddToCartRequest;
import com.example.eCommerce.model.CartItem;
import com.example.eCommerce.model.Product;
import com.example.eCommerce.model.User;
import com.example.eCommerce.repository.CartRepository;
import com.example.eCommerce.repository.ProductRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.UUID;

@Service
@RequiredArgsConstructor
public class CartService {

    private final CartRepository cartRepository;
    private final ProductRepository productRepository;
    private final ProductService productService;

    public void addToCart(User user, AddToCartRequest request) {
        Product product = productRepository.findById(request.getProductId())
                .orElseThrow(() -> new RuntimeException("Product not found"));

        productService.validateStock(product, request.getQuantity());

        CartItem item = cartRepository
                .findByUserIdAndProductId(user.getId(), product.getId())
                .orElseGet(() -> {
                    CartItem ci = new CartItem();
                    ci.setId(UUID.randomUUID().toString());
                    ci.setUserId(user.getId());
                    ci.setProductId(product.getId());
                    ci.setQuantity(0);
                    return ci;
                });

        item.setQuantity(item.getQuantity() + request.getQuantity());
        cartRepository.save(item);
    }

    public List<CartItem> getCart(String userId) {
        return cartRepository.findByUserId(userId);
    }

    public void clearCart(String userId) {
        cartRepository.deleteByUserId(userId);
    }
}
