package com.menthor.LoginApi.controller;

import com.menthor.LoginApi.service.TokenManager;
import com.menthor.LoginApi.model.JwtResponse;
import com.menthor.LoginApi.model.UserEntity;
import com.menthor.LoginApi.repository.UserRepository;
import com.menthor.LoginApi.request.LoginRequest;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/menthor")
public class LoginController {
    @Autowired
    private TokenManager tokenManager;
    @Autowired
    private BCryptPasswordEncoder bCryptPasswordEncoder;
    private final UserRepository userRepository;
    public LoginController(UserRepository userRepository) {
        this.userRepository = userRepository;
        this.bCryptPasswordEncoder = new BCryptPasswordEncoder();
    }
    @PostMapping("/login")
    public JwtResponse login(@RequestBody LoginRequest loginRequest){
            UserEntity user = userRepository.findByEmailIgnoreCase(loginRequest.getMail());
            if (user != null){
                Boolean matchPass = bCryptPasswordEncoder.matches(loginRequest.getPassword(), user.getPass());
                if (matchPass){
                    String token = tokenManager.generateToken(loginRequest.getMail());
                    JwtResponse jwtResponse = new JwtResponse();
                    jwtResponse.setEmail(user.getEmail());
                    jwtResponse.setToken(token);
                    jwtResponse.setRole(user.getRole());
                    return jwtResponse;
                }
            }else {
                return null;
            }
        return null;
    }
}
