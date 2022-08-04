package com.menthor.service;

import com.menthor.model.UserEntity;

public interface UserServiceInterface {
    UserEntity validateUser(String email, String role, String password) throws Exception;
}