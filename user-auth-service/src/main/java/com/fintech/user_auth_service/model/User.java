package com.fintech.user_auth_service.model;

import jakarta.persistence.*;

@Entity
@Table(name = "users")
public class User {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;

    @Column(nullable = false, unique = true)
    private String username;

    @Column(nullable = false)
    private String password;

    @Column(nullable = false, unique = true)
    private String email;

    // 1. Default Constructor (Hibernate ke liye zaroori hai)
    public User() {
    }





    public void setUsername(String username) {
        this.username = username;
    }



    public void setPassword(String password) {
        this.password = password;
    }



    public void setEmail(String email) {
        this.email = email;
    }
}