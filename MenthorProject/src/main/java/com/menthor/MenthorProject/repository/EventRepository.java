package com.menthor.MenthorProject.repository;

import com.menthor.MenthorProject.model.EventEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

<<<<<<< HEAD
@Repository
public interface EventRepository extends JpaRepository<EventEntity, Long> {
=======
import java.util.List;

@Repository
public interface EventRepository extends JpaRepository<EventEntity, Long> {
    public List<EventEntity> findByMatchId(Long matchId);
>>>>>>> 14e2d095118af5eca14804b4307d16608f6b77fc
}
