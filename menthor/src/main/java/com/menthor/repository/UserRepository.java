package com.menthor.repository;

import com.menthor.model.UserEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface UserRepository extends JpaRepository<UserEntity, Long> {
    public List<UserEntity> findByEmail(String email);
    public List<UserEntity> findByPhone(String phone);
    public UserEntity findByEmailIgnoreCase(String email);
    public List<UserEntity> findByRoleIgnoreCaseAndDeleted(String role, Boolean deleted);
}
