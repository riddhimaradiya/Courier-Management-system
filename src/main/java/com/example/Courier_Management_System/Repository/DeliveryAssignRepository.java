package com.example.Courier_Management_System.Repository;

import com.example.Courier_Management_System.Model.DeliveryAssignment;
import org.springframework.data.jpa.repository.JpaRepository;

public interface DeliveryAssignRepository extends JpaRepository<DeliveryAssignment, Long> {
}
