package com.fintech.user_auth_service.service;

import com.fintech.user_auth_service.dto.UserRegisterRequest;
import com.fintech.user_auth_service.model.User;
import com.fintech.user_auth_service.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

@Service
public class UserServiceImpl implements UserService{

    @Autowired
    private UserRepository userRepository;

    @Autowired
    private BCryptPasswordEncoder passwordEncoder;

    @Override
    public String registerUser(UserRegisterRequest request){
        System.out.println("Postman se aaya email: " + request.getEmail());
        if(userRepository.existsByEmail(request.getEmail())){
            return "Error: Email is already in use";
        }

        User newUser = new User();
        newUser.setUsername(request.getUsername());
        newUser.setEmail(request.getEmail());
        String hashedPassword = passwordEncoder.encode(request.getPassword());
        newUser.setPassword(hashedPassword);

        userRepository.save(newUser);

        return "user register successfully";
    }
}
