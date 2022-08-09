package com.menthor.repository;

import com.menthor.model.EventEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Date;
import java.util.List;

@Repository
public interface EventRepository extends JpaRepository<EventEntity, Long> {
    public List<EventEntity> findByMatchIdAndDeleted(Long matchId, Date deleted);
}