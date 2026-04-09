package com.example.Courier_Management_System.service;

import com.example.Courier_Management_System.Model.DeliveryAssignment;
import com.example.Courier_Management_System.Model.PackageEntity;
import com.example.Courier_Management_System.Model.User;
import com.example.Courier_Management_System.Repository.DeliveryAssignRepository;
import com.example.Courier_Management_System.Repository.PackageRepository;
import com.example.Courier_Management_System.Repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.scheduling.annotation.Async;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.List;
import java.util.concurrent.CompletableFuture;

@Service
public class DeliveryService {

    @Autowired
    private DeliveryAssignRepository repo;

    @Autowired
    private UserRepository userRepo;

    @Autowired
    private PackageRepository packageRepo;

    public DeliveryAssignment assign(Long agentId, Long packageId) {

        User agent = userRepo.findById(agentId)
                .orElseThrow(() -> new RuntimeException("User not found"));

        if (!agent.getRole().equals("AGENT")) {
            throw new RuntimeException("Only AGENT can be assigned delivery");
        }

        PackageEntity pkg = packageRepo.findById(packageId)
                .orElseThrow(() -> new RuntimeException("Package not found"));

        DeliveryAssignment d = new DeliveryAssignment();
        d.setAgent(agent);
        d.setPkg(pkg);
        d.setAssignedAt(LocalDateTime.now());
        d.setStatus("ASSIGNED");

        return repo.save(d);
    }


    @Async
    public CompletableFuture<String> assignSingle(Long agentId, Long packageId) {

        assign(agentId, packageId); // existing method

        return CompletableFuture.completedFuture("Assigned: " + packageId);
    }

    public void assignBulk(Long agentId, List<Long> packageIds) {

        User agent = userRepo.findById(agentId)
                .orElseThrow(() -> new RuntimeException("User not found"));

        if (!agent.getRole().equals("AGENT")) {
            throw new RuntimeException("Only AGENT can be assigned delivery");
        }

        for (Long pkgId : packageIds) {
            assignSingle(agentId, pkgId);
        }
    }

    public List<DeliveryAssignment> getAll() {
        return repo.findAll();
    }

    @Scheduled(fixedRate = 300000)
    public void autoUpdate() {
        List<DeliveryAssignment> list = repo.findAll();

        for (DeliveryAssignment d : list) {
            if (d.getStatus().equals("ASSIGNED")) {
                d.setStatus("IN_TRANSIT");
            } else if (d.getStatus().equals("IN_TRANSIT")) {
                d.setStatus("DELIVERED");
            }
            repo.save(d);
        }
        System.out.println("Status Updated...");
    }
}