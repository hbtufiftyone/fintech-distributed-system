package com.fintech.user_auth_service.controller;


import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class PingController {
    @GetMapping("/ping")

    public String ping(){
        return "user service is up for running";
    }
}
