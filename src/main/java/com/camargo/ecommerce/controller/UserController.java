package com.camargo.ecommerce.controller;

import com.camargo.ecommerce.model.User;
import com.camargo.ecommerce.service.UserService;
import org.springframework.web.bind.annotation.*;
import org.springframework.beans.factory.annotation.Autowired;

@RestController
@RequestMapping("/api/users")
public class UserController {

    @Autowired
    private UserService userService;
    
    @PostMapping
    public User signIn(@RequestBody LoginRequest loginRequest){
        loadUserByUsername();
        return 
    }
}