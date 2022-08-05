package com.menthor.MenthorProject.repository;

import com.menthor.MenthorProject.model.MatchEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface MatchRepository extends JpaRepository<MatchEntity, Long> {
    public MatchEntity findByMentor_id(Long mentorid);

    public MatchEntity findByMentee_id(Long menteeid);
}
