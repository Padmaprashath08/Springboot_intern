package com.example.springbootfirst.services;

import com.example.springbootfirst.models.RegisterDetails;
import com.example.springbootfirst.repository.RegisterDetailsRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.RequestBody;

import java.util.Objects;

@Service
public class AuthService {

    @Autowired
    private RegisterDetailsRepository registerDetailsRepository;
    @Autowired
    private PasswordEncoder passwordEncoder;

    public String adUserDetails(RegisterDetails register) {
        RegisterDetails registerDetails=new RegisterDetails();
        registerDetails.setEmail(register.getEmail());
        registerDetails.setPassword(passwordEncoder.encode(register.getPassword()));
        registerDetails.setEmpname(register.getEmpname());
        registerDetails.setGender(register.getGender());
        registerDetails.setDob(register.getDob());
        registerDetails.setRole(register.getRole());
        registerDetailsRepository.save(registerDetails);
        return "User Details saved successfully";
    }

    public String authentication(RegisterDetails userDetails) {
        RegisterDetails user = registerDetailsRepository.findByEmail(userDetails.getEmail());
        if(user.getEmail() != null){
            if(passwordEncoder.matches(userDetails.getPassword(), user.getPassword())){
                return "user login sucessfull";
            }
            else{
                return "Enter the correct password";
            }
        }
        else{
            return "Enter the correct email";
        }

    }
}
