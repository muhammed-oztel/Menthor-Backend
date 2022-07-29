package com.menthor.MenthorProject.repository;

import com.menthor.MenthorProject.model.ConfirmationTokenEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ConfirmationTokenRepository extends JpaRepository<ConfirmationTokenEntity, Long> {
    public ConfirmationTokenEntity findByToken(String token);
}
