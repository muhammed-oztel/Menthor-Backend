package com.menthor.LoginApi.repository;

import com.menthor.LoginApi.model.UserEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface UserRepository extends JpaRepository<UserEntity, Long> {


    public UserEntity findByEmailIgnoreCase(String email);
}
