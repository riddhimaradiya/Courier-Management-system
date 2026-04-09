package com.example.Courier_Management_System.Repository;

import com.example.Courier_Management_System.Model.User;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UserRepository extends JpaRepository<User, Long> {
}

