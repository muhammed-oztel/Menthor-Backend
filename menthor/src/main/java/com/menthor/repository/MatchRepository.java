package com.menthor.repository;

import com.menthor.model.MatchEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface MatchRepository extends JpaRepository<MatchEntity, Long> {
    public List<MatchEntity> findByMentor(Long mentor);
    public List<MatchEntity> findByMentee(Long mentee);
    public MatchEntity findByMentorOrMentee(Long userId, Long userId2);
}