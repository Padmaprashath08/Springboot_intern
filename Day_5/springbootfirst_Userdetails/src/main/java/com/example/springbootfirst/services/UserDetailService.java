package com.example.springbootfirst.services;

import com.example.springbootfirst.models.UserDetails;
import com.example.springbootfirst.repository.UserDetailsRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.RequestBody;

@Service
public class UserDetailService {

    @Autowired
    private UserDetailsRepository userDetailsRepository;
    public String adUserDetails(@RequestBody UserDetails userDetails) {
        userDetailsRepository.save(userDetails);
        return "success";
    }
}
