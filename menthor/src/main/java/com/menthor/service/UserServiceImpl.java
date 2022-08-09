package com.menthor.service;


import com.menthor.model.UserEntity;
import com.menthor.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;

@Service
@Transactional
public class UserServiceImpl implements UserServiceInterface{

    @Autowired
    UserRepository userRepository;

    @Override
    public UserEntity validateUser(String email, String role, String password) throws Exception {
        if(email != null)
            email = email.toLowerCase();
        return userRepository.findByEmailIgnoreCase(email);
    }
}