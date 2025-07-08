package com.example.springbootfirst.controllers;

import com.example.springbootfirst.models.UserDetails;
import com.example.springbootfirst.services.UserDetailService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class UserDetailController {
    @Autowired
    private UserDetailService userDetailService;
    @PostMapping
    public String addUserDetails(@RequestBody UserDetails userDetails) {
        return userDetailService.adUserDetails(userDetails);
    }
}
