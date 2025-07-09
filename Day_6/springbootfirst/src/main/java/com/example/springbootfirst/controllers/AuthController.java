package com.example.springbootfirst.controllers;

import com.example.springbootfirst.models.RegisterDetails;
import com.example.springbootfirst.services.AuthService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/auth")
public class AuthController {
    @Autowired
    private AuthService authService;
    @PostMapping
    public String addUserDetails(@RequestBody RegisterDetails userDetails) {
        return authService.adUserDetails(userDetails);
    }
    @PostMapping("/login")
    public String login(@RequestBody RegisterDetails userDetails) {
        return authService.authentication(userDetails);
    }
}
