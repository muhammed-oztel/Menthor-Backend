package com.testapp.app1.services;

import com.testapp.app1.domain.User;
import com.testapp.app1.exceptions.EtAuthException;

public interface UserService {
    User validateUser(String email, String password) throws EtAuthException;
    User registerUser(String email, String password) throws EtAuthException;
}
