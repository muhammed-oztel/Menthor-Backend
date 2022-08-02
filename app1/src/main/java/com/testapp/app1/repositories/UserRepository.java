package com.testapp.app1.repositories;

import com.testapp.app1.domain.User;
import com.testapp.app1.exceptions.EtAuthException;

public interface UserRepository {
    Integer create(String email, String password) throws EtAuthException;

    User findByEmailAndPassword(String email, String password) throws EtAuthException;

    Integer getCountByEmail(String email);

    User findById(Integer userId);
}
