package com.example.Courier_Management_System.service;

import com.example.Courier_Management_System.Model.Order;
import com.example.Courier_Management_System.Model.PackageEntity;
import com.example.Courier_Management_System.Repository.OrderRepository;
import com.example.Courier_Management_System.Repository.PackageRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class PackageService {

    @Autowired
    private PackageRepository packageRepository;

    @Autowired
    private OrderRepository orderRepo;

    public PackageEntity create(Long orderId, PackageEntity pkg) {
        Order order = orderRepo.findById(orderId).orElseThrow(() -> new RuntimeException("Order not found"));
        pkg.setOrder(order);
        pkg.setStatus("READY");
        return packageRepository.save(pkg);
    }

    public List<PackageEntity> getAllPackages() {
        return packageRepository.findAll();
    }
}
