package com.fintech.user_auth_service.dto;

public class UserRegisterRequest {
    private String username;
    private String email;
    private String password;

    // 1. Standard No-Arg Constructor (Spring Framework ke liye zaroori hai)
    public UserRegisterRequest() {
    }

    // 2. Sahi Getters aur Setters jo variables ko map karenge
    public String getUsername() {
        return this.username;
    }



    public String getEmail() {
        return this.email;
    }



    public String getPassword() {
        return this.password;
    }

}