package com.camargo.ecommerce.controller;

import com.camargo.ecommerce.dto.LoginRequest;
import com.camargo.ecommerce.dto.LoginResponse;
import com.camargo.ecommerce.model.User;
import com.camargo.ecommerce.service.UserService;
import org.springframework.web.bind.annotation.*;
import org.springframework.beans.factory.annotation.Autowired;

@RestController
@RequestMapping("/api/users")
public class UserController {

    @Autowired
    private UserService userService;
    
    @PostMapping("/login")
    public LoginResponse login(@RequestBody LoginRequest loginRequest){
        // Implementar lógica de login aqui
        return new LoginResponse();
    }
    
    @PostMapping("/register")
    public User register(@RequestBody User user){
        return userService.save(user);
    }
}