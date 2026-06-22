package com.fintech.user_auth_service.dto;

public class UserLoginRequest {
    public String email;
    public String password;

    public UserLoginRequest(){

    }
    public String getEmail(){
        return this.email;
    }

    public void setEmail(){
        this.email = email;
    }

    public String getPassword(){
        return this.password;
    }

    public void setPassword(){
        this.password = password;
    }
}
