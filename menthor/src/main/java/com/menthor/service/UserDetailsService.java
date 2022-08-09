package com.menthor.service;
import java.util.ArrayList;

import com.menthor.model.UserEntity;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Lazy;
import org.springframework.security.config.annotation.web.WebSecurityConfigurer;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

import javax.annotation.PostConstruct;
@Service
public class UserDetailsService {
//    private final UserService userService;

    @Autowired()
    private BCryptPasswordEncoder passwordEncoder;

    public UserDetailsService(@Lazy BCryptPasswordEncoder passwordEncoder) {
        this.passwordEncoder = passwordEncoder;
    }


//    @PostConstruct


//    @Override
//    public UserDetails loadUserByUsername(UserEntity entity) throws UsernameNotFoundException {
//        if (users.containsKey(username)){
//            return new User(username, users.get(username), new ArrayList<>());
//        }
//        throw new UsernameNotFoundException(username);
//    }
}