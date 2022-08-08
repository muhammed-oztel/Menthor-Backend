package com.menthor.MenthorProject.repository;

import com.menthor.MenthorProject.model.MatchEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

<<<<<<< HEAD
@Repository
public interface MatchRepository extends JpaRepository<MatchEntity, Long> {
    public List<MatchEntity> findByMentor(Long mentor);

    public List<MatchEntity> findByMentee(Long mentee);
=======

@Repository
public interface MatchRepository extends JpaRepository<MatchEntity, Long> {
>>>>>>> 14e2d095118af5eca14804b4307d16608f6b77fc
}
