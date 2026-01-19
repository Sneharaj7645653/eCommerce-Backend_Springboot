package com.example.eCommerce.service;

import com.example.eCommerce.model.User;
import com.example.eCommerce.repository.UserRepository;
import org.springframework.stereotype.Service;
import com.example.eCommerce.dto.CreateUserRequest;

@Service
public class UserService {

    private final UserRepository userRepository;

    public UserService(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    public User createUser(CreateUserRequest request) {

        userRepository.findByEmail(request.getEmail())
                .ifPresent(u -> {
                    throw new RuntimeException("Email already exists");
                });

        User user = new User();
        user.setUsername(request.getUsername());
        user.setEmail(request.getEmail());

        return userRepository.save(user);
    }

    public User getById(String userId) {
        return userRepository.findById(userId)
                .orElseThrow(() -> new RuntimeException("User not found"));
    }
}

