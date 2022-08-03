package com.menthor.repository;

import com.menthor.model.ConfirmationTokenEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ConfirmationTokenRepository extends JpaRepository<ConfirmationTokenEntity, Long> {
    public ConfirmationTokenEntity findByToken(String token);
    public ConfirmationTokenEntity findByUserId(Long id);
}
