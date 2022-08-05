package com.menthor.MenthorProject.repository;

import com.menthor.MenthorProject.model.EventEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface EventRepository extends JpaRepository<EventEntity, Long> {
    public List<EventEntity> findByMatchId(Long matchId);
}
