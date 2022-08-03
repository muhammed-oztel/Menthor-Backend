package com.menthor.LoginApi.service;


import com.menthor.LoginApi.model.UserEntity;
import com.menthor.LoginApi.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;

@Service
@Transactional
public class UserServceImpl implements UserService{

    @Autowired
    UserRepository userRepository;

    @Override
    public UserEntity validateUser(String email, String role, String password) throws Exception {
        if(email != null)
            email = email.toLowerCase();
        return userRepository.findByEmail(email);
    }
}
