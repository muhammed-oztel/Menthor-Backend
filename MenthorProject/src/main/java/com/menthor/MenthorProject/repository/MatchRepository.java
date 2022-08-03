package com.menthor.MenthorProject.repository;

import com.menthor.MenthorProject.model.MatchEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;


@Repository
public interface MatchRepository extends JpaRepository<MatchEntity, Long> {
}
