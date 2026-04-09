package com.example.Courier_Management_System.Controller;

import com.example.Courier_Management_System.DTO.BulkAssignRequest;
import com.example.Courier_Management_System.Model.DeliveryAssignment;
import com.example.Courier_Management_System.service.DeliveryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/deliveries")
public class DeliveryAssignController {
    @Autowired
    private DeliveryService deliveryService;

    @PostMapping("/assign")
    public DeliveryAssignment assign(@RequestParam Long agentId,
                                     @RequestParam Long packageId) {
        return deliveryService.assign(agentId, packageId);
    }

    @PostMapping("/bulk-assign")
    public String bulkAssign(@RequestBody BulkAssignRequest request) {

        deliveryService.assignBulk(request.getAgentId(), request.getPackageIds());

        return "Bulk Assignment Started Successfully";
    }

    @GetMapping("/getAllDelivery")
    public List<DeliveryAssignment> getAll() {
        return deliveryService.getAll();
    }
}