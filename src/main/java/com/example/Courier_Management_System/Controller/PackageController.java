package com.example.Courier_Management_System.Controller;

import com.example.Courier_Management_System.Model.PackageEntity;
import com.example.Courier_Management_System.service.PackageService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/packages")
public class PackageController {

    @Autowired
    private PackageService packageService;

    @PostMapping("/{orderId}")
    public PackageEntity create(@PathVariable Long orderId, @RequestBody PackageEntity pkg) {
        return packageService.create(orderId, pkg);
    }

    @GetMapping("/getAllPackages")
    public List<PackageEntity> getAllPackages() {
        return packageService.getAllPackages();
    }
}
