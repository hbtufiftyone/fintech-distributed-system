package com.fintech.user_auth_service.controller;

import com.fintech.user_auth_service.dto.UserLoginRequest;
import com.fintech.user_auth_service.dto.UserRegisterRequest;
import com.fintech.user_auth_service.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/auth")
public class AuthController {

    @Autowired
    private UserService userService;

    @Autowired
    private com.fintech.user_auth_service.security.JwtUtil jwtUtil;

    @PostMapping("/register")
    public ResponseEntity<String> registerUser(@RequestBody UserRegisterRequest request){
        String response = userService.registerUser(request);

        if(response.contains("Error")){
            return ResponseEntity.badRequest().body(response);
        }

        return ResponseEntity.ok(response);
    }

    @PostMapping("/login")
    public ResponseEntity<String> loginUser(@RequestBody UserLoginRequest request){
        String response = userService.loginUser(request);

        if(response.contains("Error")){
            return ResponseEntity.badRequest().body(response);
        }

        return ResponseEntity.ok(response);
    }

    @GetMapping("/profile")
    public ResponseEntity<String> getUserProfile(@RequestHeader(value = "Authorization", required = false) String authHeader) {

        // 🐛 DEBUG LINE 1: Dekhte hain Postman se kya aaya
        System.out.println("---- DEBUGGING START ----");
        System.out.println("Postman se aaya header: ->" + authHeader + "<-");

        // Check karo ki token bheja hai ya nahi
        if (authHeader == null || !authHeader.startsWith("Bearer ")) {
            System.out.println("Error: Ya toh header null hai, ya 'Bearer ' se start nahi ho raha!"); // 🐛 DEBUG LINE 2
            return ResponseEntity.status(401).body("Error: Access denied token is missing");
        }

        String token = authHeader.substring(7);
        System.out.println("Kholne ke baad Token: " + token); // 🐛 DEBUG LINE 3

        try {
            String email = jwtUtil.extractEmail(token);
            System.out.println("Token success! Email nikla: " + email); // 🐛 DEBUG LINE 4
            return ResponseEntity.ok("Welcome to your private profile! Yeh raha tumhara email: " + email);

        } catch (Exception e) {
            System.out.println("Token Decode Fail Hua: " + e.getMessage()); // 🐛 DEBUG LINE 5
            return ResponseEntity.status(401).body("Error: Invalid or expired token!");
        }
    }


}
