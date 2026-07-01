package com.fintech.user_auth_service.dto;

import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Pattern;
import jakarta.validation.constraints.Size;

public class UserRegisterRequest {

    @NotBlank(message = "Username Khali nhi rh skta")


    private String username;

    @NotBlank(message = "email Khali nhi rh skta")
    @Email(message = "Email should be in correct format")
    private String email;

    @NotBlank(message = "Email can't be empty")
    @Size(min = 6 , message = "Your password should have more then 6 character")
    @Pattern(regexp = "^(?=.*[a-z])(?=.*[A-Z])(?=.*\\d).*$",
            message = "Password mein kam se kam 1 chota letter (a-z), 1 bada letter (A-Z) aur 1 number (0-9) hona zaroori hai!")
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