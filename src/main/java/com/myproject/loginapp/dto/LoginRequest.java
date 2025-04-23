package com.myproject.loginapp.dto;

public class LoginRequest {
    @jakarta.validation.constraints.Email(message = "Invalid email")
    @jakarta.validation.constraints.NotBlank(message = "Email is required")
    private String email;

    @jakarta.validation.constraints.NotBlank(message = "Password is required")
    private String password;

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }
}
