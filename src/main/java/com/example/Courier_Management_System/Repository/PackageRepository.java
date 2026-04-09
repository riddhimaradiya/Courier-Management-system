package com.example.Courier_Management_System.Repository;

import com.example.Courier_Management_System.Model.PackageEntity;
import org.springframework.data.jpa.repository.JpaRepository;


public interface PackageRepository extends JpaRepository<PackageEntity, Long> {
}
