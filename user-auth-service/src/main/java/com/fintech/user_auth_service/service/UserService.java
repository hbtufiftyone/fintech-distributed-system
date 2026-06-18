package com.fintech.user_auth_service.service;

import com.fintech.user_auth_service.dto.UserRegisterRequest;

public interface UserService {
    String registerUser(UserRegisterRequest request);
}
