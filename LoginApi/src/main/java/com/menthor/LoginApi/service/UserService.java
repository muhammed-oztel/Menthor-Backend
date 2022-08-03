package com.menthor.LoginApi.service;

import com.menthor.LoginApi.model.UserEntity;

public interface UserService {
    UserEntity validateUser(String email, String role, String password) throws Exception;
}
