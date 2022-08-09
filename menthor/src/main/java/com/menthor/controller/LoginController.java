package com.menthor.controller;

import com.menthor.service.TokenManager;
import com.menthor.model.JwtResponse;
import com.menthor.model.UserEntity;
import com.menthor.repository.UserRepository;
import com.menthor.request.LoginRequest;
import com.menthor.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.web.bind.annotation.*;

@CrossOrigin(origins = "*")
@RestController
@RequestMapping("/menthor")
public class LoginController {
    @Autowired
    private TokenManager tokenManager;
    @Autowired
    private AuthenticationManager authenticationManager;
    @Autowired
    private BCryptPasswordEncoder bCryptPasswordEncoder;

    @Autowired
    private UserService userService;

    private final UserRepository userRepository;

    public LoginController(UserRepository userRepository) {
        this.userRepository = userRepository;
        this.bCryptPasswordEncoder = new BCryptPasswordEncoder();
    }


    @PostMapping("/login")
    public JwtResponse login(@RequestBody LoginRequest loginRequest){
        // authenticationManager.authenticate(new UsernamePasswordAuthenticationToken(loginRequest.getMail(), loginRequest.getPassword()));
        UserEntity user = userRepository.findByEmailIgnoreCase(loginRequest.getMail());
        if (user != null && user.getDeleted() == null){
            Boolean matchPass = bCryptPasswordEncoder.matches(loginRequest.getPassword(), user.getPass());
            if (matchPass){
                String token = tokenManager.generateToken(loginRequest.getMail());
                JwtResponse jwtResponse = new JwtResponse();
                jwtResponse.setEmail(user.getEmail());
                jwtResponse.setToken(token);
                jwtResponse.setRole(user.getRole());
                jwtResponse.setId(user.getId());
                jwtResponse.setEnabled(user.getEnabled());
                return jwtResponse;
            }
        }else {
            return null;
        }
        return null;
    }
}