package com.myproject.loginapp.service;

import com.myproject.loginapp.dto.LoginRequest;
import com.myproject.loginapp.dto.UserRequest;
import com.myproject.loginapp.dto.UserResponse;
import com.myproject.loginapp.entities.User;
import com.myproject.loginapp.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
public class UserService {
    @Autowired
    private UserRepository userRepository;

    private final BCryptPasswordEncoder passwordEncoder = new BCryptPasswordEncoder();


    // User Registration
    public UserResponse register(UserRequest request) {
        if (userRepository.findByEmail(request.getEmail()).isPresent()) {
            throw new RuntimeException("Email already exists");
        }
        User newUser = new User();
        newUser.setName(request.getName());
        newUser.setEmail(request.getEmail());
        newUser.setPassword(passwordEncoder.encode(request.getPassword()));

        User savedUser = userRepository.save(newUser);
        return new UserResponse(savedUser.getId(), savedUser.getName(), savedUser.getEmail());
    }

    // User Login
    public UserResponse login(LoginRequest request) {
        Optional<User> userOpt = userRepository.findByEmail(request.getEmail());
        if (userOpt.isEmpty()) {
            throw new RuntimeException("Email or password is incorrect");
        }

        User user = userOpt.get();
        if (!passwordEncoder.matches(request.getPassword(), user.getPassword())) {
            throw new RuntimeException("Email or password is incorrect");
        }

        return new UserResponse(user.getId(), user.getName(), user.getEmail());

    }

    // Listar todos os usuários
    public List<UserResponse> listAllUsers() {
        List<User> users = userRepository.findAll();
        return users.stream()
                .map(user -> new UserResponse(user.getId(), user.getName(), user.getEmail()))
                .collect(Collectors.toList());
    }

    // Buscar usuário por email
    public UserResponse findByEmail(String email) {
        User user = userRepository.findByEmail(email)
                .orElseThrow(() -> new RuntimeException("Usuário não encontrado"));

        return new UserResponse(user.getId(), user.getName(), user.getEmail());
    }
}
