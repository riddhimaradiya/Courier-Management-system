package com.example.Courier_Management_System.service;

import com.example.Courier_Management_System.Model.Order;
import com.example.Courier_Management_System.Model.User;
import com.example.Courier_Management_System.Repository.OrderRepository;
import com.example.Courier_Management_System.Repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.time.LocalDateTime;
import java.util.List;

@Service
public class OrderService {

    @Autowired
    private OrderRepository orderRepository;

    @Autowired
    private UserRepository userRepo;

    // 1. Create Order
    public Order create(Long customerId, Order order) {
        User customer = userRepo.findById(customerId)
                .orElseThrow(() -> new RuntimeException("User not found"));
        order.setCustomer(customer);
        order.setStatus("CREATED");
        order.setCreatedAt(LocalDateTime.now());
        return orderRepository.save(order);
    }

    public List<Order> getAllOrder() {
        return orderRepository.findAll();
    }
}
