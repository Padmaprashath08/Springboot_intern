package com.example.springbootfirst.services;

import com.example.springbootfirst.jwt.JwtTokenProvider;
import com.example.springbootfirst.models.JwtResponse;
import com.example.springbootfirst.models.RegisterDetails;
import com.example.springbootfirst.models.Roles;
import com.example.springbootfirst.models.UserDetailsDto;
import com.example.springbootfirst.repository.RegisterDetailsRepository;
import com.example.springbootfirst.repository.RolesRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import java.util.HashSet;
import java.util.Optional;
import java.util.Set;

@Service
public class AuthService {

    @Autowired
    private RegisterDetailsRepository registerDetailsRepository;
    @Autowired
    AuthenticationManager authenticationManager;
    @Autowired
    JwtTokenProvider jwtTokenProvider;

    @Autowired
    RolesRepository rolesRepository;

    @Autowired
    private PasswordEncoder passwordEncoder;

    public String adUserDetails(UserDetailsDto register) {
        RegisterDetails registerDetails=new RegisterDetails();
        registerDetails.setEmpId(register.getEmpId());
        registerDetails.setName(register.getName());
        registerDetails.setEmail(register.getEmail());
        registerDetails.setPassword(passwordEncoder.encode(register.getPassword()));
        registerDetails.setUserName(register.getUserName());
        Set<Roles> roles=new HashSet<>();
        for(String roleName:register.getRoles()){
            Roles role=rolesRepository.findByRoleName(roleName).orElseThrow(()->new RuntimeException("Role not found"));
            System.out.println(role);
            roles.add(role);
        }
        registerDetails.setRoles(roles);
        registerDetailsRepository.save(registerDetails);
        return "User Details saved successfully";
    }

    public JwtResponse authenticate(RegisterDetails login) {

        Authentication authentication =authenticationManager.authenticate(new UsernamePasswordAuthenticationToken(
                login.getUserName(),login.getPassword()
        ));
        JwtResponse a=new JwtResponse();
        a.setUsername(login.getUserName());
        a.setToken(jwtTokenProvider.generateToken(authentication));
        String role = registerDetailsRepository.getRoleNamesByUserName(login.getUserName()).stream().findFirst().orElse(null);

        a.setRoles(role);
        return a;
    }
    public Optional<RegisterDetails> getUserByUsername(String username) {
        return Optional.ofNullable(registerDetailsRepository.findByUserName(username));
    }
}
