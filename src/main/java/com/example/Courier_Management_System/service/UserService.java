package com.example.Courier_Management_System.service;

import com.example.Courier_Management_System.Model.User;
import com.example.Courier_Management_System.Repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.stereotype.Service;
import java.time.LocalDateTime;

@Service
public class UserService {

    @Autowired
    private UserRepository userRepository;

    public User create(User user) {
        if (!user.getRole().equals("ADMIN") &&
                !user.getRole().equals("MANAGER") &&
                !user.getRole().equals("AGENT") &&
                !user.getRole().equals("CUSTOMER")) {

            throw new RuntimeException("Invalid Role");
        }

        user.setCreatedAt(LocalDateTime.now());
        return userRepository.save(user);
    }

    public Page<User> getUsers(int page, int size) {

        Pageable pageable = PageRequest.of(page, size);
        return userRepository.findAll(pageable);
    }
}
