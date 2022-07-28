package com.menthor.MenthorProject.repository;

import com.menthor.MenthorProject.model.UserDetailEntity;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UserDetailRepository extends JpaRepository<UserDetailEntity, Long> {
}
