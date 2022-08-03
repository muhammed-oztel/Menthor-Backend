package com.menthor.MenthorProject.repository;

import com.menthor.MenthorProject.model.UserEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface UserRepository extends JpaRepository<UserEntity, Long> {
    public List<UserEntity> findByEmail(String email);
    public List<UserEntity> findByPhone(String phone);
    public UserEntity findByEmailIgnoreCase(String email);
    public List<UserEntity> findByRoleIgnoreCaseAndDeleted(String role, Boolean deleted);
    public List<UserEntity> findByNameContainingIgnoreCaseAndRoleIgnoreCase(String name, String role);
    public List<UserEntity> findBySurnameContainingIgnoreCaseAndRoleIgnoreCase(String surname, String role2);
}
