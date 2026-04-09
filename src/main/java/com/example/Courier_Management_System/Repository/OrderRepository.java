package com.example.Courier_Management_System.Repository;

import com.example.Courier_Management_System.Model.Order;
import org.springframework.data.jpa.repository.JpaRepository;

public interface OrderRepository extends JpaRepository<Order, Long> {
}
