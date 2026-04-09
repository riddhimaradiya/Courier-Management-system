package com.example.Courier_Management_System.Controller;

import com.example.Courier_Management_System.Model.Order;
import com.example.Courier_Management_System.service.OrderService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/order")
public class OrderController {

    @Autowired
    private OrderService orderService;

    @PostMapping("/{customerId}")
    public Order create(@PathVariable Long customerId, @RequestBody Order order) {
        return orderService.create(customerId, order);
    }

    @GetMapping("/getAllOrder")
    public List<Order> getAllOrder() {
        return orderService.getAllOrder();
    }
}
