package com.example.Courier_Management_System.Controller;

import com.example.Courier_Management_System.Model.User;
import com.example.Courier_Management_System.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/user")
public class UserController {

    @Autowired
    private UserService userService;

    @PostMapping("/create")
    public User create(@RequestBody User user) {
        return userService.create(user);
    }

    @GetMapping("/paginated")
    public Page<User> getUsers(@RequestParam int page,
                               @RequestParam int size) {
        return userService.getUsers(page, size);
    }
}
