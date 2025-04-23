package com.myproject.loginapp.controller;

import com.myproject.loginapp.dto.LoginRequest;
import com.myproject.loginapp.dto.UserRequest;
import com.myproject.loginapp.dto.UserResponse;
import com.myproject.loginapp.service.UserService;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/users")
public class UserController {
    @Autowired
    private UserService userService;

    @PostMapping("/register")
    public UserResponse register(@RequestBody @Valid UserRequest request) {
        return userService.register(request);
    }

    @PostMapping("/login")
    public UserResponse login(@RequestBody @Valid LoginRequest request) {
        return userService.login(request);
    }

    @GetMapping
    public List<UserResponse> listAll() {
        return userService.listAllUsers();
    }

    @GetMapping("/{email}")
    public UserResponse getByEmail(@PathVariable String email) {
        return userService.findByEmail(email);
    }
}
