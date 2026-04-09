package com.example.Courier_Management_System.Model;

import jakarta.persistence.*;

import java.time.LocalDateTime;

@Entity
@Table(name = "delivery_assignments")
public class DeliveryAssignment {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @ManyToOne
    private User agent;

    @ManyToOne
    private PackageEntity pkg;

    private LocalDateTime assignedAt;

    private String status;// ASSIGNED, IN_TRANSIT, DELIVERED

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public User getAgent() {
        return agent;
    }

    public void setAgent(User agent) {
        this.agent = agent;
    }

    public PackageEntity getPkg() {
        return pkg;
    }

    public void setPkg(PackageEntity pkg) {
        this.pkg = pkg;
    }

    public LocalDateTime getAssignedAt() {
        return assignedAt;
    }

    public void setAssignedAt(LocalDateTime assignedAt) {
        this.assignedAt = assignedAt;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }
}
