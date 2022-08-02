package com.menthor.MenthorProject.repository;

import com.menthor.MenthorProject.model.UserDetailEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface UserDetailRepository extends JpaRepository<UserDetailEntity, Long> {
    public List<UserDetailEntity> findByUserId(Long id);
}
